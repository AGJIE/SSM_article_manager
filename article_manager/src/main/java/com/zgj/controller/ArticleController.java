package com.zgj.controller;

import com.zgj.bean.Article;
import com.zgj.bean.Reply;
import com.zgj.bean.Words;
import com.zgj.service.ArticleService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章Controller层
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    /**
     * 声明一个变量用于区别我访问的是文章管理页面，还是回收站页面
     * 0：访问的是文章管理页面     1：表示访问的是回收站页面
     */
    private int goId = 0;

    /**
     * 注入Service层
     */
    @Autowired
    private  ArticleService articleService;


    /**
     * 跳转到文章管理页面
     */
    @RequestMapping(value = "/toArticleManage")
    public String toArticleManage() {
        //设置我区别访问页面的状态码
        goId = 0;
        return "redirect:findByPage.do";
    }

    /**
     * 跳转到文章编辑页面
     */
    @RequestMapping(value = "/toArticleWrite")
    public String toArticleWrite() {
        return "/view/article/articleWrite";
    }

    /**
     * 跳转到回收站页面
     */
    @RequestMapping(value = "/toArticleTrash")
    public String toArticleTrash() {
        //设置这个状态码为1表示我访问的是回收站页面
        System.out.println("回收站页面运行了.........");

        goId = 1;
        return "redirect:findByPage.do";
    }




    /**
     * 添加文章信息
     */
    @RequestMapping(value = "/saveArticle")
    public String saveArticle(Article article, Model model) {
        try {
            articleService.saveArticle(article);
            model.addAttribute("message","文章添加成功" );
            return "view/info/message";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 分页查询
     *
     *
     */
    @RequestMapping(value = "/findByPage")
    public String findByPage(@RequestParam(value = "pageCode", defaultValue = "1" ,required = false ) int pageCode,
                             @RequestParam(value = "pageSize", defaultValue = "10",required = false ) int pageSize,
                                HttpServletRequest request, Model model) {

        //封装分页数据
        String a_name = request.getParameter("a_name");//文章作者
        System.out.println("a_name = " + a_name);
        String verify = request.getParameter("r_verify");//审核
        System.out.println("verify = " + verify);
        String publish = request.getParameter("r_publish");//发布
        System.out.println("publish = " + publish);
        String status = request.getParameter("r_status");//状态
        System.out.println("status = " + status);

        String r_author = null;
        Integer r_verify = null;
        Integer r_publish = null;
        Integer r_status = null;

        if (a_name != null) {
            r_author = "%" + a_name + "%";
        }

        if (verify != null) {
            if (verify.equals("已审核")) {
                r_verify = 1;
            } else if (verify.equals("未审核")) {
                r_verify = 0;
            }
        }

        if (publish != null) {
            if (publish.equals("已发布")) {
                r_publish = 1;
            } else if (publish.equals("未发布")) {
                r_publish = 0;
            }
        }

        if (status != null) {
            if (status.equals("存在")) {
                r_status = 0;
            } else if (status.equals("已删除")) {
                r_status = 1;
            }
        }

        Map<String, Object> conMap = new HashMap<>();
        conMap.put("r_author", r_author);
        conMap.put("r_verify", r_verify);
        conMap.put("r_publish", r_publish);
        conMap.put("r_status", r_status);

        //把状态码也放入Map集合中
        conMap.put("goId", goId);

        //回显数据
        model.addAttribute("page", articleService.findByPage(pageCode, pageSize, conMap));

        if (goId == 1) {
            return "/view/article/articleTrash";
        }
        return "/view/article/articleManage";

    }

    /**
     * 将文章删除，即软删除
     * @param r_id
     * @return
     */
    @RequestMapping(value = "/clean")
    public String clean(@RequestParam int r_id) {
        articleService.clean(r_id);
        return "redirect:findByPage.do";
    }




//    回收站

    /**
     * 将文章从回收站恢复
     * @param r_id
     * @return
     */
    @RequestMapping(value = "/restore")
    public String restore(@RequestParam int r_id) {
        articleService.restore(r_id);
        return "redirect:findByPage.do";
    }

    /**
     * 删除文章，永久性
     * @param r_id
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam int r_id) {
        articleService.delete(r_id);
        return "redirect:findByPage.do";
    }


    //留言内容
    //保持留言内容
    @RequestMapping(value = "/saveWords")
    public String saveWords(Words words) {
        if (words != null) {
            String article_id = words.getLw_for_article_id();
            articleService.saveWords(words);
            return "redirect:toArticleView.do?r_id=" + article_id;
        } else {
            return null;
        }
    }

    //保存回复内容
    @RequestMapping(value = "/saveReply")
    public String saveReply(Reply Reply) {
        if (Reply != null) {
            String article_id = Reply.getLr_for_article_id();
            articleService.saveReply(Reply);
            return "redirect:toArticleView.do?r_id=" + article_id;
        } else {
            return null;
        }
    }


//    文章内容页面

    /**
     * 跳转到查看文章内容页面
     * @param r_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/toArticleView")
    public String findById(@RequestParam int r_id, Model model) {
        Article article = articleService.findById(r_id);

        if (article != null) {
            List<Words> byWords = articleService.findByWords();
            List<Reply> byReply = articleService.findByReply();

            model.addAttribute("lw_list", byWords);
            model.addAttribute("lr_list", byReply);
            model.addAttribute("article", article);
            return "/view/article/articleView";
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/update")
    public String update(Article article, Model model) {
        if (article != null) {
            articleService.update(article);
            return "redirect:toArticleManage.do";
        } else {
            model.addAttribute("message", "文章信息获取失败");
            return "/view/info/message";
        }
    }




    //    跳转到更新内容页面
    @RequestMapping(value = "/toEditPage")
    public String editPage(@RequestParam int r_id, Model model) {
        Article article = articleService.findById(r_id);

    //        待完善
        if (article != null) {
            model.addAttribute("article", article);
            return "/view/article/articleUpdate";
        } else {
            return null;
        }
    }



}

