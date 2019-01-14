/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.dao.impl;

import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.dao.ITeacherDao;
import mybatis.graduate.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Autowired
    private TeacherMapper teacherMapper;

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
    public List<Teacher> getTeachers(final int firstResult, final int maxResults) {
        int pageNo = firstResult / maxResults + 1;
//        ArteryInterceptor.startPage(pageNo, maxResults, false); // 自动分页

        return teacherMapper.getTeachers(firstResult, maxResults);
    }

    @Override
    public int getTeachersCount() {
        return teacherMapper.getTeachersCount();
    }

}
