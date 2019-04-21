/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Teacher;

import java.util.List;
import java.util.Map;

/**
 * <p> Description: 教师信息 服务接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
public interface ITeacherService {

    /**
     * 分页获取教师信息列表。<br>
     * 方法调用者需要保证 <code>pageSize</code> 和 <code>pageNo</code> 均为正整数，实现类不检查其合法性
     *
     * @param pageSize 页大小，即每页有几条记录
     * @param pageNo   页码，从 1 开始
     * @return 教师信息列表
     */
    PageInfo<Teacher> getTeachers(int pageSize, int pageNo);

    /**
     * 获取教师信息的数量
     *
     * @return 教师信息数量
     */
    int getTeachersCount();

    /**
     * 根据 工号 获取教师信息
     *
     * @param id 教师信息 工号
     * @return 教师信息
     */
    Teacher getTeacherById(Integer id);


    /**
     * 根据 工号 获取教师信息的数量
     *
     * @param id 教师信息 工号
     * @return 教师信息的数量
     */
    int getTeachersCountById(Integer id);

    /**
     * 登录校验 判断该账号密码是否匹配
     *
     * @param map 包含工号和密码
     * @return 教师信息的数量
     */
    int getTeachersCountByMap(Map map);

    /**
     * 添加教师信息
     *
     * @param teacher 教师信息
     */
    void addTeacher(Teacher teacher);

    /**
     * 更新教师信息
     *
     * @param teacher 教师信息
     */
    void updateTeacher(Teacher teacher);

    /**
     * 删除教师信息
     *
     * @param id 教师信息 工号
     */
    void deleteTeacherById(Integer id);
}
