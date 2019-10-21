package com.zgj.service.impl;

import com.zgj.bean.Article;
import com.zgj.bean.PageBean;
import com.zgj.bean.Reply;
import com.zgj.bean.Words;
import com.zgj.dao.ArticleMapper;
import com.zgj.service.ArticleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    /**
     * 注入Mapper
     */
    @Autowired
    ArticleMapper articleMapper;

    //日志
    private Logger log = Logger.getLogger(AdminServiceImpl.class);

    /**
     * 保存文章信息
     * @param article
     */
    @Override
    public void saveArticle(Article article) {
        log.info("service的文章保存功能执行了");
        articleMapper.saveArticle(article);
    }

    /**
     * 分页查询方法
     * @param pageCode
     * @param pageSize
     * @param conMap
     * @return 分页查询结果
     */
    @Override
    public PageBean<Article> findByPage(int pageCode, int pageSize, Map<String, Object> conMap) {

        System.out.println("pageCode = " + pageCode);
        System.out.println("pageSize = " + pageSize);
        System.out.println("conMap = " + conMap);

        PageBean<Article> pageBean = new PageBean<>();

        //获取contcoller层封装的状态码
        Integer goId = (Integer) conMap.get("goId");

        //封装数据
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = 0;
        if (goId == 0) {
            //访问的是文章列表页面
            totalCount  = articleMapper.selectCount();
            System.out.println("totalCount = " + totalCount);
        } else if (goId == 1) {
            //访问的是回收站页面
            totalCount = articleMapper.selectCount2();
            System.out.println("totalCount = " + totalCount);
        }
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //设置limit起始位置和终止位置
        conMap.put("start", (pageCode - 1) * pageSize);
        conMap.put("size", pageBean.getPageSize());

        System.out.println("pageBean = " + pageBean);

        List<Article> list = articleMapper.findConByPage(conMap);
        pageBean.setBeanList(list);

        for (Object obj : list) {
            System.out.println( obj);
        }

        return pageBean;
    }

    /**
     * 文章删除功能（仅把文章放入到回收站）
     * @param r_id
     */
    @Override
    public void clean(int r_id) {
        articleMapper.clean(r_id);
    }

//    回收站
    /**
     * 恢复已删除的文章
     * @param r_id
     */
    @Override
    public void restore(int r_id) {
        articleMapper.restore(r_id);
    }

    /**
     * 删除文章：永久性
     * @param r_id
     */
    @Override
    public void delete(int r_id) {
        articleMapper.delete(r_id);
    }


    //文章内容页面

    /**
     * 通过id查找文章
     * @param r_id
     * @return
     */
    @Override
    public Article findById(int r_id) {
        Article article = articleMapper.findById(r_id);
        return article;
    }

    @Override
    public void update(Article article) {
        articleMapper.update(article);
    }


//    留言内容

    /**
     * 查询留言内容
     * @return
     */
    @Override
    public List<Words> findByWords() {
        List<Words> byWords = articleMapper.findByWords();
        return byWords;
    }

    /**
     * 查询回复内容
     * @return
     */
    @Override
    public List<Reply> findByReply() {
        List<Reply> byReply = articleMapper.findByReply();
        return byReply;
    }

    @Override
    public void saveWords(Words words) {
        articleMapper.saveWords(words);
    }

    @Override
    public void saveReply(Reply reply) {
        articleMapper.saveReply(reply);
    }
}
