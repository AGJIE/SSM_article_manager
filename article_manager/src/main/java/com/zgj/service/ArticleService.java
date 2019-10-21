package com.zgj.service;

import com.zgj.bean.Article;
import com.zgj.bean.PageBean;
import com.zgj.bean.Reply;
import com.zgj.bean.Words;

import java.util.List;
import java.util.Map;

public interface ArticleService {


    /**
     * 保存文章信息
     * @param article
     */
    void saveArticle(Article article);

    /**
     * 分页查询
     * @param pageCode
     * @param pageSize
     * @param conMap
     * @return
     */
    PageBean<Article> findByPage(int pageCode, int pageSize, Map<String, Object> conMap);

    /**
     * 文章删除功能（仅把文章放入到回收站）
     * @param r_id
     */
    void clean(int r_id);

//  回收站
    /**
     * 恢复已删除的文章
     * @param r_id
     */
    void restore(int r_id);

    /**
     * 删除文章：永久性
     * @param r_id
     */
    void delete(int r_id);

  //    文章内容页面

    /**
     * 通过id查找文章
     * @param r_id
     * @return
     */
    Article findById(int r_id);

    /**
     * 更新文章信息
     * @param article
     */
    void update(Article article);

    //    留言内容

    /**
     * 查询留言内容
     * @return
     */
    List<Words> findByWords();

    /**
     * 查询回复内容
     * @return
     */
    List<Reply> findByReply();

    /**
     *  保存留言内容
     * @param words
     */
    void saveWords(Words words);

    /**
     *  保存回复内容
     * @param reply
     */
    void saveReply(Reply reply);
}
