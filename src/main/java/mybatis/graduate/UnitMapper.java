/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mybatis.graduate;

import com.thunisoft.graduate.common.model.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p> Description: 单位信息 Mybatis数据访问映射接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
public interface UnitMapper {

    /**
     * 获取单位信息列表
     *
     * @return 单位信息列表
     */
    List<Unit> getUnits(Map map);

    /**
     * 获取单位信息的数量
     *
     * @return 单位信息数量
     */
    int getUnitsCount();

    /**
     * 根据 组织机构代码 获取单位信息
     *
     * @param id 单位信息 组织机构代码
     * @return 单位信息
     */
    Unit getUnitById(String id);

    /**
     * 根据 组织机构代码 获取单位信息的数量
     *
     * @param id 单位信息 组织机构代码
     * @return 单位信息
     */
    int getUnitsCountById(String id);

    /**
     * 添加单位信息
     *
     * @param unit 单位信息
     */
    void addUnit(Unit unit);

    /**
     * 更新单位信息
     *
     * @param unit 单位信息
     */
    void updateUnit(Unit unit);

    /**
     * 删除单位信息
     *
     * @param id 单位信息 组织机构代码
     */
    void deleteUnitById(String id);
}
