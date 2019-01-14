/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service.impl;

import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Unit;
import com.thunisoft.graduate.dao.IUnitDao;
import com.thunisoft.graduate.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> Description: 单位信息 服务实现</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
@Service
@Transactional
public class UnitServiceImpl implements IUnitService {
    /**
     * 单位信息 数据访问对象
     */
    private final IUnitDao unitDao;

    @Autowired
    public UnitServiceImpl(IUnitDao unitDao) {
        this.unitDao = unitDao;
    }


    @Override
    public String getUnitById(String id) {
        unitDao.getUnitById(id);
        return Constants.C_CURD_SUCCESS;
    }

    @Override
    public String addUnit(Unit unit) {
        unitDao.addUnit(unit);
        return Constants.C_CURD_SUCCESS;
    }

    @Override
    public String updateUnit(Unit unit) {
        unitDao.updateUnit(unit);
        return Constants.C_CURD_SUCCESS;
    }

    @Override
    public String deleteUnitById(String id) {
        unitDao.deleteUnitById(id);
        return Constants.C_CURD_SUCCESS;
    }

    @Override
    public List<Unit> getUnits(int pageSize, int pageNo) {
        int firstResult = (pageNo - 1) * pageSize;
        int maxResults;
        maxResults = pageSize;
        return unitDao.getUnits(firstResult, maxResults);
    }

    @Override
    public int getUnitsCount() {
        return unitDao.getUnitsCount();
    }

}
