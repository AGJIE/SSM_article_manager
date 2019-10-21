package com.zgj.controller;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zgj.bean.Admin;
import com.zgj.service.AdminService;
import com.zgj.service.ArticleService;
import com.zgj.service.impl.AdminServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 管理人员Controller层
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 注入Service
     */
    @Autowired
    private AdminService adminService;

    @Autowired
    ArticleService articleService;

    //日志
    private Logger log = Logger.getLogger(AdminController.class);


    /**
     * 登录功能
     * @param a_name
     * @param a_password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String findlogin(@RequestParam String a_name, @RequestParam String a_password, Model model, HttpSession session) {
        log.info("AdminController的登录功能执行了");
        Admin admin = adminService.findLogin(a_name);//查询是否有该账户
        if (admin != null) {
            if (admin.getA_password().equals(a_password)) {
                //密码匹配成功，转入文章管理系统页面
                session.setAttribute("name", admin.getA_name());
                return "/view/page";
            } else {
                model.addAttribute("message", "用户名或密码错误");
                return "/view/login/info";
            }
        } else {
            model.addAttribute("message", "登录失败");
            return "/view/login/info";
        }
    }

    /**
     * 登录失败跳转回登录页面
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        log.info("AdminController的登录失败跳转回登录页面执行了");
        return "redirect:/index.jsp";
    }


    /**
     * 注册——添加用户
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String register(Admin admin, HttpSession session) {
        adminService.register(admin);
        session.setAttribute("name", admin.getA_name());
        return "/view/page";
    }


    /**
     * 根据用户名查询
     */
    @ResponseBody
    @RequestMapping(value = "/findByName" ,method = RequestMethod.POST)
    public String findByName(@RequestBody Admin  admin) {
        log.info("AdminController的根据用户名查询执行了");
        Admin byName = adminService.findByName(admin.getA_name());
        System.out.println(JSONObject.toJSONString(byName));
        return JSONObject.toJSONString(byName);
    }

    /**
     * 返回首页
     * @return
     */
    @RequestMapping(value = "/page")
    public String page() {
        return "/view/page";
    }

    /**
     * 退出登录的功能
     */
    @RequestMapping(value = "outLogin")
    public String outLogin(HttpSession session) {
        session.invalidate();
        return "redirect:/index.jsp";
    }


}
