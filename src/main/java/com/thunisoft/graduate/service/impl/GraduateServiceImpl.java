/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service.impl;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Graduate;
import com.thunisoft.graduate.dao.IGraduateDao;
import com.thunisoft.graduate.service.IGraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p> Description: 毕业生信息 服务实现</p>
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
public class GraduateServiceImpl implements IGraduateService {
    /**
     * 毕业生信息 数据访问对象
     */
    private final IGraduateDao graduateDao;

    @Autowired
    public GraduateServiceImpl(IGraduateDao graduateDao) {
        this.graduateDao = graduateDao;
    }


    @Override
    public Graduate getGraduateById(Integer id) {
        return graduateDao.getGraduateById(id);
    }

    @Override
    public void addGraduate(Graduate graduate) {
        graduateDao.addGraduate(graduate);
    }

    @Override
    public void updateGraduate(Graduate graduate) {
        graduateDao.updateGraduate(graduate);
    }

    @Override
    public void deleteGraduateById(Integer id) {
        graduateDao.deleteGraduateById(id);
    }

    @Override
    public PageInfo<Graduate> getGraduates(int pageSize, int pageNo, Map map) {
        int firstResult = (pageNo - 1) * pageSize;
        int maxResults = pageSize;
        return graduateDao.getGraduates(firstResult, maxResults, map);
    }

    @Override
    public int getGraduatesCount() {
        return graduateDao.getGraduatesCount();
    }

    @Override
    public int getGraduateCountById(Integer id) {
        return graduateDao.getGraduateCountById(id);
    }

}
