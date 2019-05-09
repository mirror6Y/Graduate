/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mybatis.graduate;

import com.thunisoft.graduate.common.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p> Description: 教师信息 Mybatis数据访问映射接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
public interface TeacherMapper {

    /**
     * 获取教师信息列表
     *
     * @param map 包含工号和教师姓名
     * @return 教师信息列表
     */
    List<Teacher> getTeachers(Map map);

    /**
     * 获取教师信息的数量
     *
     * @return 教师信息数量
     */
    int getTeachersCount();

    /**
     * 根据 工号 获取教师信息
     *
     * @param id 工号
     * @return 教师信息
     */
    Teacher getTeacherById(Integer id);

    /**
     * 根据 工号 获取教师信息的数量 (获取信息or注册信息)
     *
     * @param id 工号
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
     * @param id 工号
     */
    void deleteTeacherById(Integer id);
}
