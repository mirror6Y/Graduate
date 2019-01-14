/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service;

import com.thunisoft.graduate.common.model.Graduate;

import java.util.List;

/**
 * <p> Description: 毕业生信息 服务接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 * @version 1.0
 * @author 由stage工具自动生成
 * @author liuye
 */
public interface IGraduateService {

    /**
     * 分页获取毕业生信息列表。<br>
     * 方法调用者需要保证 <code>pageSize</code> 和 <code>pageNo</code> 均为正整数，实现类不检查其合法性
     * @param pageSize 页大小，即每页有几条记录
     * @param pageNo 页码，从 1 开始
     * @return 毕业生信息列表
     */
    List<Graduate> getGraduates(int pageSize, int pageNo);
    
    /**
     * 获取毕业生信息的数量
     * @return 毕业生信息数量
     */
    int getGraduatesCount();
    
    /**
     * 根据 编号 获取毕业生信息
     * @param id 毕业生信息 编号
     * @return 毕业生信息
     */
    String getGraduateById(Integer id);
    
    /**
     * 添加毕业生信息
     * @param graduate 毕业生信息
     */
    String addGraduate(Graduate graduate);
    
    /**
     * 更新毕业生信息
     * @param graduate 毕业生信息
     */
    String updateGraduate(Graduate graduate);
    
    /**
     * 删除毕业生信息
     * @param id 毕业生信息 编号
     */
    String deleteGraduateById(Integer id);
}
