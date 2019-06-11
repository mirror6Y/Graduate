package com.thunisoft.graduate.controller;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
        teacherService.addTeacher(teacher);
        return Constants.C_SUCCESS;
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
    public String updateTeacher(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return Constants.C_SUCCESS;
    }

    /**
     * 通过ID查找教师信息
     * url:"http://localhost:8080/teacher/getTeacherById/{id}"
     *
     * @return ModelAndView
     */
    // == @RequestMapping(value = "/getTeacherById/{id}", method = RequestMethod.GET)
    @GetMapping("/getTeacherById/{id}/{operation}")
    public ModelAndView getTeacherById(Model model, @PathVariable("id") Integer id, @PathVariable("operation") String operation) {
        //判断是否存在工号为ID的教师信息
        int presence = teacherService.getTeachersCountById(id);
        if (presence > 0)
        {
            Teacher teacher = teacherService.getTeacherById(id);
            if ("update".equals(operation))
            {
                model.addAttribute("teacherUpdate", teacher);
                return new ModelAndView("teacher/teacherUpdate");
            } else if ("delete".equals(operation))
            {
                model.addAttribute("teacherDelete", teacher);
                return new ModelAndView("teacher/teacherDelete");
            } else
            {
                model.addAttribute("teacherInfo", teacher);
                return new ModelAndView("teacher/teacherInfo");
            }
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
    public ModelAndView getTeachers(Model model, @RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Teacher teacher) {
        //列表过滤条件
        Map<String, Object> map = new HashMap<>();
        map.put("college", teacher.getCollege());
        map.put("name", teacher.getName());
        //教师列表
        PageInfo<Teacher> pageInfo = teacherService.getTeachers(pageSize, pageNum, map);
        model.addAttribute("pageInfo", pageInfo);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        return new ModelAndView("teacher/teacher");
    }

}
