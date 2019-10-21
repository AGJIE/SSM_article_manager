package com.zgj.bean;

/**
 * 文章
 */
public class Article {

    private Integer r_id;//id
    private String r_author;//作者
    private String r_summary;//总结
    private String r_content;//内容
    private String r_date;//日期
    private Integer r_verify;//审核
    private Integer r_publish;//发布
    private Integer r_status;//地位

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_author() {
        return r_author;
    }

    public void setR_author(String r_author) {
        this.r_author = r_author;
    }

    public String getR_summary() {
        return r_summary;
    }

    public void setR_summary(String r_summary) {
        this.r_summary = r_summary;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    public String getR_date() {
        return r_date;
    }

    public void setR_date(String r_date) {
        this.r_date = r_date;
    }

    public Integer getR_verify() {
        return r_verify;
    }

    public void setR_verify(Integer r_verify) {
        this.r_verify = r_verify;
    }

    public Integer getR_publish() {
        return r_publish;
    }

    public void setR_publish(Integer r_publish) {
        this.r_publish = r_publish;
    }

    public Integer getR_status() {
        return r_status;
    }

    public void setR_status(Integer r_status) {
        this.r_status = r_status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "r_id=" + r_id +
                ", r_author='" + r_author + '\'' +
                ", r_summary='" + r_summary + '\'' +
                ", r_content='" + r_content + '\'' +
                ", r_date='" + r_date + '\'' +
                ", r_verify=" + r_verify +
                ", r_publish=" + r_publish +
                ", r_status=" + r_status +
                '}';
    }
}
