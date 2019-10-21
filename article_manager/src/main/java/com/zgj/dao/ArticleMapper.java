package com.zgj.dao;

import com.zgj.bean.Article;
import com.zgj.bean.Reply;
import com.zgj.bean.Words;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArticleMapper {

    /**
     * 保存文章信息
     * @param article
     */
    void saveArticle(Article article);

    /**
     * 查询（未clean）总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询（已clean）记录总数
     * @return
     */
    int selectCount2();

    /**
     * 查询分页数据
     * @param map
     * @return
     */
    List<Article> findConByPage(Map<String, Object> map);

    /**
     * 文章删除功能（仅把文章放入到回收站）
     * @param r_id
     */
    void clean(int r_id);


//    回收站
    /**
     * 恢复已删除的文章
     * @param r_id
     */
    void restore(int r_id);

    /**
     * 删除文章
     * @param r_id
     */
    void delete(int r_id);

 //    文章内容页面

    /**
     * 查找文章
     * @param r_id
     * @return
     */
    Article findById(int r_id);

    /**
     * 更新文章信息
     * @param article
     */
    void update(Article article);


//    留言

    /**
     *  查询所有留言信息
     * @return
     */
    List<Words> findByWords();

    /**
     *  查询所有回复信息
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
