/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Protocol;
import com.thunisoft.graduate.dao.IProtocolDao;
import mybatis.graduate.ProtocolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p> Description: 三方协议 数据访问对象MyBatis实现</p>
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
public class ProtocolDaoMyBatisImpl implements IProtocolDao {

    @Autowired
    private ProtocolMapper protocolMapper;

    @Override
    public Protocol getProtocolById(String id) {
        return protocolMapper.getProtocolById(id);
    }

    @Override
    public void addProtocol(Protocol protocol) {
        if (protocol.getId() == null)
        {
            protocol.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        protocolMapper.addProtocol(protocol);
    }

    @Override
    public void updateProtocol(Protocol protocol) {
        protocolMapper.updateProtocol(protocol);
    }

    @Override
    public void deleteProtocolById(String id) {
        protocolMapper.deleteProtocolById(id);
    }

    @Override
    public PageInfo<Protocol> getProtocols(final int firstResult, final int maxResults, Map map) {
        int pageNo = firstResult / maxResults + 1;
        PageHelper.startPage(pageNo, maxResults); //开始起始页
        List<Protocol> protocols = protocolMapper.getProtocols(map); // 获取数据
        return new PageInfo<>(protocols);
    }

    @Override
    public int getProtocolsCount() {
        return protocolMapper.getProtocolsCount();
    }

    @Override
    public int getProtocolCountById(String id) {
        return protocolMapper.getProtocolCountById(id);
    }

}
