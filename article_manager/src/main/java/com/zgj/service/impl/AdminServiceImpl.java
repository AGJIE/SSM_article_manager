package com.zgj.service.impl;


import com.zgj.bean.Admin;
import com.zgj.dao.AdminMapper;
import com.zgj.service.AdminService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    //日志
    private Logger log = Logger.getLogger(AdminServiceImpl.class);

    /**
     * 登录功能
     * @param a_name
     * @return
     */
    @Override
    public Admin findLogin(String a_name) {
        log.info("service的登录功能执行了");
        Admin admin = adminMapper.findLogin(a_name);
        return admin;
    }

    /**
     * 注册功能
     * @param admin
     */
    @Override
    public void register(Admin admin) {
        log.info("service的注册功能执行了");
        adminMapper.register(admin);
    }

    /**
     * 根据用户名查询
     * @param a_name
     * @return
     */
    @Override
    public Admin findByName(String a_name) {
        Admin admin = adminMapper.findByName(a_name);
        return admin;
    }


}
