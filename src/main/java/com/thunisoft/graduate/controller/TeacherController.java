package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private final ITeacherService teacherService;

    @Autowired
    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }


    /**
     * 添加教师信息
     * url:"http://localhost:8080/teacher/addTeacher"
     * 通过<form>表单模拟验证
     */
    // == @RequestMapping(value="/addTeacher",method=RequestMethod.POST)
    @ResponseBody
    @PostMapping("/addTeacher")
    public String addTeacher() {
//        String id=request.getParameter("");
        Teacher teacher = new Teacher(201213, "蓝曦臣", 1, "计算机工程学院", "1918", "18341114205", "");
        teacherService.addTeacher(teacher);
        return Constants.C_SUCCESS;
    }

    /**
     * 删除教师信息
     * url:"http://localhost:8080/teacher/deleteTeacher/{id}"
     * 注意无法通过浏览器的链接来模拟检验,可以通过 jquery的 $.ajax方法，并type="delete"
     */
    // == @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @DeleteMapping("/deleteTeacherById/{id}")
    public String deleteTeacherById(@PathVariable("id") Integer id) {
        teacherService.deleteTeacherById(id);
        return Constants.C_SUCCESS;
    }

    /**
     * 修改教师信息
     * url:"http://localhost:8080/teacher/updateTeacher"
     * 验证：可以通过 jquery的 $.ajax方法，并type="put",同时注意data形式——A=a&B=b&C=c
     */
    // == @RequestMapping(value="/updateTeacher",method=RequestMethod.PUT)
    @ResponseBody
    @PutMapping("/updateTeacher")
    public String updateTeacher() {
        Teacher teacher = new Teacher(201213, "123456", "蓝忘机", 1, "计算机工程学院", "1918", "18341114205", "");
        teacherService.updateTeacher(teacher);
        return Constants.C_SUCCESS;
    }

    /**
     * 通过ID查找教师信息
     * url:"http://localhost:8080/teacher/getTeacherById/{id}"
     *
     * @return Teacher
     */
    // == @RequestMapping(value = "/getTeacherById/{id}", method = RequestMethod.GET)
    @GetMapping("/getTeacherById/{id}")
    public String getTeacherById(@PathVariable("id") Integer id) {
        teacherService.getTeacherById(id);
        return Constants.C_SUCCESS;
    }

}
