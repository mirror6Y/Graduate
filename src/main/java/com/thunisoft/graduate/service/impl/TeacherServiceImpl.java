/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service.impl;

import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.dao.ITeacherDao;
import com.thunisoft.graduate.service.ITeacherService;

import java.util.List;

/**
 * <p> Description: 教师信息 服务实现</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 * @version 1.0
 * @author 由stage工具自动生成
 * @author liuye
 */
public class TeacherServiceImpl implements ITeacherService {
    /**
     * 教师信息 数据访问对象
     */
    private ITeacherDao teacherDao;
    /**
     * 注入 教师信息 数据访问对象
     * @param teacherDao 教师信息 数据访问对象
     */
    public void setTeacherDao(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    @Override
    public List<Teacher> getTeachers(int pageSize, int pageNo) {
        int firstResult = (pageNo - 1) * pageSize;
        int maxResults = pageSize;
        return teacherDao.getTeachers(firstResult, maxResults);
    }

    @Override
    public int getTeachersCount() {
        return teacherDao.getTeachersCount();
    }

}
