package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final ITeacherService teacherService;

    @Autowired
    public LoginController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("login")
    public String loginCheck(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json,charset=UTF-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<>();
        map.put("id", account);
        map.put("password", password);
        int presence = teacherService.getTeachersCountByMap(map);
        if (presence > 0)
        {
            String name = teacherService.getTeacherById(Integer.parseInt(account)).getName();
            request.getSession().setAttribute("loginName", name);//将用户信息放到session中
            request.getSession().setMaxInactiveInterval(3600);//设置session存储时间，以秒为单位，3600=60*60即为60分钟
            return "index";
        } else if (null == map.get("id"))
        {
            return "id is null";
        } else if (null == map.get("password"))
        {
            return "password is null";
        } else
        {
            return "id or password is error";
        }

    }

    @RequestMapping(value="logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView result = new ModelAndView("sign-in");
        HttpSession session = request.getSession();//获取当前session
        if(session!=null){
            session.invalidate();//关闭session
        }
        return result;

    }



}
