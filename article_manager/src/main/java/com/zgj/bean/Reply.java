package com.zgj.bean;

/**
 * 回复
 */
public class Reply {

    private Integer lr_id;//id
    private String lr_name;//名字
    private String lr_date;//日期
    private String lr_content;//内容
    private String lr_for_name;//名字
    private String lr_for_words;//话
    private String lr_for_reply;//回复
    private String lr_for_article_id;//文章id

    public Integer getLr_id() {
        return lr_id;
    }

    public void setLr_id(Integer lr_id) {
        this.lr_id = lr_id;
    }

    public String getLr_name() {
        return lr_name;
    }

    public void setLr_name(String lr_name) {
        this.lr_name = lr_name;
    }

    public String getLr_date() {
        return lr_date;
    }

    public void setLr_date(String lr_date) {
        this.lr_date = lr_date;
    }

    public String getLr_content() {
        return lr_content;
    }

    public void setLr_content(String lr_content) {
        this.lr_content = lr_content;
    }

    public String getLr_for_name() {
        return lr_for_name;
    }

    public void setLr_for_name(String lr_for_name) {
        this.lr_for_name = lr_for_name;
    }

    public String getLr_for_words() {
        return lr_for_words;
    }

    public void setLr_for_words(String lr_for_words) {
        this.lr_for_words = lr_for_words;
    }

    public String getLr_for_reply() {
        return lr_for_reply;
    }

    public void setLr_for_reply(String lr_for_reply) {
        this.lr_for_reply = lr_for_reply;
    }

    public String getLr_for_article_id() {
        return lr_for_article_id;
    }

    public void setLr_for_article_id(String lr_for_article_id) {
        this.lr_for_article_id = lr_for_article_id;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "lr_id=" + lr_id +
                ", lr_name='" + lr_name + '\'' +
                ", lr_date='" + lr_date + '\'' +
                ", lr_content='" + lr_content + '\'' +
                ", lr_for_name='" + lr_for_name + '\'' +
                ", lr_for_words='" + lr_for_words + '\'' +
                ", lr_for_reply='" + lr_for_reply + '\'' +
                ", lr_for_article_id='" + lr_for_article_id + '\'' +
                '}';
    }
}
