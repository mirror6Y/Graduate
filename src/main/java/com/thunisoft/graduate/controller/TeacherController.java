package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mirror6
 * @Date: 2018/12/25 16:01
 */

@RestController
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;
}
