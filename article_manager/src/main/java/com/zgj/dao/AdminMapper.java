package com.zgj.dao;


import com.zgj.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 管理员
 */
public interface AdminMapper {

//    登录功能
    Admin findLogin(String a_name);

    //    注册功能
    void register(Admin admin);

    //  根据用户名查询
    Admin findByName(String a_name);



}
