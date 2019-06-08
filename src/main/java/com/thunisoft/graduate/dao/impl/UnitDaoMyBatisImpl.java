/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Unit;
import com.thunisoft.graduate.dao.IUnitDao;
import mybatis.graduate.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p> Description: 单位信息 数据访问对象MyBatis实现</p>
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
public class UnitDaoMyBatisImpl implements IUnitDao {

    private final UnitMapper unitMapper;

    @Autowired
    public UnitDaoMyBatisImpl(UnitMapper unitMapper) {
        this.unitMapper = unitMapper;
    }

    @Override
    public Unit getUnitById(String id) {
        return unitMapper.getUnitById(id);
    }

    @Override
    public void addUnit(Unit unit) {
//        if (unit.getId() == null) {
//            unit.setId(UUID.randomUUID().toString().replace("-", ""));
//        }
        unitMapper.addUnit(unit);
    }

    @Override
    public void updateUnit(Unit unit) {
        unitMapper.updateUnit(unit);
    }

    @Override
    public void deleteUnitById(String id) {
        unitMapper.deleteUnitById(id);
    }

    @Override
    public PageInfo<Unit> getUnits(final int firstResult, final int maxResults, Map map) {
        int pageNo = firstResult / maxResults + 1;
        PageHelper.startPage(pageNo, maxResults); //开始起始页
        List<Unit> units = unitMapper.getUnits(map); // 获取数据
        return new PageInfo<>(units);
    }

    @Override
    public int getUnitsCount() {
        return unitMapper.getUnitsCount();
    }

    @Override
    public int getUnitsCountById(String id) {
        return unitMapper.getUnitsCountById(id);
    }

}
