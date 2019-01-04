/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service;

import com.thunisoft.graduate.common.model.Protocol;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> Description: 三方协议 服务接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 * @version 1.0
 * @author 由stage工具自动生成
 * @author liuye
 */
public interface IProtocolService {

    /**
     * 分页获取三方协议列表。<br>
     * 方法调用者需要保证 <code>pageSize</code> 和 <code>pageNo</code> 均为正整数，实现类不检查其合法性
     * @param pageSize 页大小，即每页有几条记录
     * @param pageNo 页码，从 1 开始
     * @return 三方协议列表
     */
    List<Protocol> getProtocols(int pageSize, int pageNo);
    
    /**
     * 获取三方协议的数量
     * @return 三方协议数量
     */
    int getProtocolsCount();
    
    /**
     * 根据 协议编号 获取三方协议
     * @param id 三方协议 协议编号
     * @return 三方协议
     */
    Protocol getProtocolById(String id);
    
    /**
     * 添加三方协议
     * @param protocol 三方协议
     */
    void addProtocol(Protocol protocol);
    
    /**
     * 更新三方协议
     * @param protocol 三方协议
     */
    void updateProtocol(Protocol protocol);
    
    /**
     * 删除三方协议
     * @param id 三方协议 协议编号
     */
    void deleteProtocolById(String id);
}
