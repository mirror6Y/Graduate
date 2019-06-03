/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mybatis.graduate;

import com.thunisoft.graduate.common.model.Graduate;

import java.util.List;
import java.util.Map;

/**
 * <p> Description: 毕业生信息 Mybatis数据访问映射接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
public interface GraduateMapper {

    /**
     * 获取毕业生信息列表
     *
     * @return 毕业生信息列表
     */
    List<Graduate> getGraduates(Map map);

    /**
     * 获取毕业生信息的数量
     *
     * @return 毕业生信息数量
     */
    int getGraduatesCount();

    /**
     * 根据 编号 获取毕业生信息
     *
     * @param id 毕业生信息 编号
     * @return 毕业生信息
     */
    Graduate getGraduateById(Integer id);

    /**
     * 根据 编号 获取毕业生信息的数量
     *
     * @param id 毕业生信息 编号
     * @return 毕业生信息的数量
     */
    int getGraduateCountById(Integer id);

    /**
     * 添加毕业生信息
     *
     * @param graduate 毕业生信息
     */
    void addGraduate(Graduate graduate);

    /**
     * 更新毕业生信息
     *
     * @param graduate 毕业生信息
     */
    void updateGraduate(Graduate graduate);

    /**
     * 删除毕业生信息
     *
     * @param id 毕业生信息 编号
     */
    void deleteGraduateById(Integer id);
}
