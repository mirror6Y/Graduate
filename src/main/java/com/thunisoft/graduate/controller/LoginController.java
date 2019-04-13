package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


//********************
        response.setContentType("application/json,charset=UTF-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<>();
        map.put("id", account);
        map.put("password", password);
        int presence = teacherService.getTeachersCountByMap(map);
        if (presence > 0)
        {
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


}
