package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: mirror6
 * @Date: 2018/12/25 16:01
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    /**
     * 注入teacher的服务层
     */
    @Autowired
    private ITeacherService teacherService;


    /**
     * 添加教师信息
     * 增加 restful 风格
     * url:"http://localhost/student/addone"
     * 通过<form>表单模拟验证
     *
     * @param
     */
    // == @RequestMapping(value="/addTeacher",method=RequestMethod.POST)
    @PostMapping("/addTeacher")
    @ResponseBody
    public String addTeacher() throws Exception {

//        String id=request.getParameter("");
        Teacher teacher = new Teacher(201213, "蓝忘机", 1, "计算机工程学院", "1918", "18341114205", "");
        teacherService.addTeacher(teacher);
        return Constants.C_SUCCESS;
    }

}
