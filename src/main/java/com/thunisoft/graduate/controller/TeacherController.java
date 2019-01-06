package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     */
    public String addTeacher(Teacher teacher) throws Exception {
        teacherService.addTeacher(teacher);
        return Constants.C_SUCCESS;
    }

    public static void main(String[] args) {
        TeacherController t = new TeacherController();
        Teacher teacher = new Teacher("201213", "蓝忘机", 1, "计算机工程学院", "1918", "18341114025", null);
        try
        {
            t.addTeacher(teacher);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
