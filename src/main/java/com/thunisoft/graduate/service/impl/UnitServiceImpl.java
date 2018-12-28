/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service.impl;

import com.thunisoft.graduate.common.model.Unit;
import com.thunisoft.graduate.dao.IUnitDao;
import com.thunisoft.graduate.service.IUnitService;

import java.util.List;

/**
 * <p> Description: 单位信息 服务实现</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 * @version 1.0
 * @author 由stage工具自动生成
 * @author liuye
 */
public class UnitServiceImpl implements IUnitService {
    /**
     * 单位信息 数据访问对象
     */
    private IUnitDao unitDao;
    /**
     * 注入 单位信息 数据访问对象
     * @param unitDao 单位信息 数据访问对象
     */
    public void setUnitDao(IUnitDao unitDao) {
        this.unitDao = unitDao;
    }

    @Override
    public Unit getUnitById(String id) {
        return unitDao.getUnitById(id);
    }

    @Override
    public void addUnit(Unit unit) {
        unitDao.addUnit(unit);
    }

    @Override
    public void updateUnit(Unit unit) {
        unitDao.updateUnit(unit);
    }

    @Override
    public void deleteUnitById(String id) {
        unitDao.deleteUnitById(id);
    }

    @Override
    public List<Unit> getUnits(int pageSize, int pageNo) {
        int firstResult = (pageNo - 1) * pageSize;
        int maxResults = pageSize;
        return unitDao.getUnits(firstResult, maxResults);
    }

    @Override
    public int getUnitsCount() {
        return unitDao.getUnitsCount();
    }

}
