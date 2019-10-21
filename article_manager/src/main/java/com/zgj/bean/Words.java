package com.zgj.bean;

/**
 * 话
 */
public class Words {

    private Integer lw_id;//id
    private String lw_name;//name
    private String lw_date;//日期
    private String lw_content;//内容
    private String lw_for_name;//名字
    private String lw_for_article_id;//id

    public Integer getLw_id() {
        return lw_id;
    }

    public void setLw_id(Integer lw_id) {
        this.lw_id = lw_id;
    }

    public String getLw_name() {
        return lw_name;
    }

    public void setLw_name(String lw_name) {
        this.lw_name = lw_name;
    }

    public String getLw_date() {
        return lw_date;
    }

    public void setLw_date(String lw_date) {
        this.lw_date = lw_date;
    }

    public String getLw_content() {
        return lw_content;
    }

    public void setLw_content(String lw_content) {
        this.lw_content = lw_content;
    }

    public String getLw_for_name() {
        return lw_for_name;
    }

    public void setLw_for_name(String lw_for_name) {
        this.lw_for_name = lw_for_name;
    }

    public String getLw_for_article_id() {
        return lw_for_article_id;
    }

    public void setLw_for_article_id(String lw_for_article_id) {
        this.lw_for_article_id = lw_for_article_id;
    }

    @Override
    public String toString() {
        return "Words{" +
                "lw_id=" + lw_id +
                ", lw_name='" + lw_name + '\'' +
                ", lw_date='" + lw_date + '\'' +
                ", lw_content='" + lw_content + '\'' +
                ", lw_for_name='" + lw_for_name + '\'' +
                ", lw_for_article_id='" + lw_for_article_id + '\'' +
                '}';
    }
}
