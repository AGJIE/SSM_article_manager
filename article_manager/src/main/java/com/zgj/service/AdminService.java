package com.zgj.service;



import com.zgj.bean.Admin;

import java.util.List;

public interface AdminService {

    //    登录功能
    Admin findLogin(String a_name);

    //    注册功能
    void register(Admin admin);

    //  根据用户名查询
    Admin findByName(String a_name);


}
