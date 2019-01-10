/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service;

import com.thunisoft.graduate.common.model.Unit;

import java.util.List;

/**
 * <p> Description: 单位信息 服务接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 * @version 1.0
 * @author 由stage工具自动生成
 * @author liuye
 */
public interface IUnitService {

    /**
     * 分页获取单位信息列表。<br>
     * 方法调用者需要保证 <code>pageSize</code> 和 <code>pageNo</code> 均为正整数，实现类不检查其合法性
     * @param pageSize 页大小，即每页有几条记录
     * @param pageNo 页码，从 1 开始
     * @return 单位信息列表
     */
    List<Unit> getUnits(int pageSize, int pageNo);
    
    /**
     * 获取单位信息的数量
     * @return 单位信息数量
     */
    int getUnitsCount();
    
    /**
     * 根据 组织机构代码 获取单位信息
     * @param id 单位信息 组织机构代码
     * @return 单位信息
     */
    String getUnitById(String id);
    
    /**
     * 添加单位信息
     * @param unit 单位信息
     */
    String addUnit(Unit unit);
    
    /**
     * 更新单位信息
     * @param unit 单位信息
     */
    String updateUnit(Unit unit);
    
    /**
     * 删除单位信息
     * @param id 单位信息 组织机构代码
     */
    String deleteUnitById(String id);
}
