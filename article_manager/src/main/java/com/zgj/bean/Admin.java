package com.zgj.bean;

/**
 * 管理员实体类
 */
public class Admin {

    private Integer a_id;//id
    private String a_name;//账号
    private String a_password;//密码

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_password='" + a_password + '\'' +
                '}';
    }
}
