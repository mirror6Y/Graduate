/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Graduate;
import com.thunisoft.graduate.dao.IGraduateDao;
import mybatis.graduate.GraduateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p> Description: 毕业生信息 数据访问对象MyBatis实现</p>
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
public class GraduateDaoMyBatisImpl implements IGraduateDao {

    @Autowired
    private GraduateMapper graduateMapper;

    @Override
    public Graduate getGraduateById(Integer id) {
        return graduateMapper.getGraduateById(id);
    }

    @Override
    public void addGraduate(Graduate graduate) {
//        if (graduate.getId() == null) {
//            graduate.setId(UUID.randomUUID().toString().replace("-", ""));
//        }
        graduateMapper.addGraduate(graduate);
    }

    @Override
    public void updateGraduate(Graduate graduate) {
        graduateMapper.updateGraduate(graduate);
    }

    @Override
    public void deleteGraduateById(Integer id) {
        graduateMapper.deleteGraduateById(id);
    }

    @Override
    public PageInfo<Graduate> getGraduates(final int firstResult, final int maxResults, Map map) {
        int pageNo = firstResult / maxResults + 1;
        PageHelper.startPage(pageNo, maxResults); //开始起始页
        List<Graduate> graduates = graduateMapper.getGraduates(map); // 获取数据
        return new PageInfo<>(graduates);
    }

    @Override
    public int getGraduatesCount() {
        return graduateMapper.getGraduatesCount();
    }

    @Override
    public int getGraduateCountById(Integer id) {
        return graduateMapper.getGraduateCountById(id);
    }

}
