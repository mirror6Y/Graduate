package com.thunisoft.graduate.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.service.ITeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: mirror6
 * @Date: 2018/12/25 16:01
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {


    private final ITeacherService teacherService;

    /**
     * 构造器注入teacherService
     */
    @Autowired
    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }


    /**
     * 添加教师信息
     * url:"http://localhost:8080/teacher/addTeacher"
     */
    // == @RequestMapping(value="/addTeacher",method=RequestMethod.POST)
    @PostMapping("/addTeacher")
    public String addTeacher(Teacher teacher) {
//        Teacher teacher = new Teacher(201213, "蓝曦臣", 1, "计算机工程学院", "1918", "18341114205", "");
        teacherService.addTeacher(teacher);
        return Constants.C_SUCCESS;
//        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

    /**
     * 删除教师信息
     * url:"http://localhost:8080/teacher/deleteTeacher/{id}"
     */
    // == @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/deleteTeacherById/{id}")
    public String deleteTeacherById(@PathVariable("id") Integer id) {
        teacherService.deleteTeacherById(id);
        return Constants.C_SUCCESS;
    }

    /**
     * 修改教师信息
     * url:"http://localhost:8080/teacher/updateTeacher"
     */
    // == @RequestMapping(value="/updateTeacher",method=RequestMethod.PUT)
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
    public ModelAndView getTeacherById(Model model, @PathVariable("id") Integer id) {
        //判断是否存在工号为ID的教师信息
        Integer presence = teacherService.getTeachersCountById(id);
        if (presence > 0)
        {
            Teacher teacher = teacherService.getTeacherById(id);
            model.addAttribute("teacher", teacher);
            return new ModelAndView("teacherInfo");
        } else
        {
            return new ModelAndView("error");
        }
    }

    /**
     * 教师信息分页
     * url:"http://localhost:8088/teacher/getTeachers"
     *
     * @return Teachers
     */
    @GetMapping("/getTeachers")
    public ModelAndView getTeachers(Model model, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNo) {
        PageInfo<Teacher> pageInfo = teacherService.getTeachers(pageSize, pageNo);
        model.addAttribute("pageInfo", pageInfo);
        return new ModelAndView("teacher");
    }

}
