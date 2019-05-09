/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.dao.ITeacherDao;
import mybatis.graduate.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p> Description: 教师信息 数据访问对象MyBatis实现</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
@Repository
public class TeacherDaoMyBatisImpl implements ITeacherDao {


    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherDaoMyBatisImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }


    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacherById(Integer id) {
        teacherMapper.deleteTeacherById(id);
    }

    @Override
    public PageInfo<Teacher> getTeachers(final int firstResult, final int maxResults, Map map) {
        int pageNo = firstResult / maxResults + 1;
        PageHelper.startPage(pageNo, maxResults); //开始起始页
        List<Teacher> teachers = teacherMapper.getTeachers(map); // 获取数据
        return new PageInfo<>(teachers);
    }

    @Override
    public int getTeachersCount() {
        return teacherMapper.getTeachersCount();
    }

    @Override
    public int getTeachersCountById(Integer id) {
        return teacherMapper.getTeachersCountById(id);
    }

    @Override
    public int getTeachersCountByMap(Map map) {
        return teacherMapper.getTeachersCountByMap(map);
    }


}
