/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.service.impl;

import com.thunisoft.graduate.common.model.Protocol;
import com.thunisoft.graduate.dao.IProtocolDao;
import com.thunisoft.graduate.service.IProtocolService;

import java.util.List;

/**
 * <p> Description: 三方协议 服务实现</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
public class ProtocolServiceImpl implements IProtocolService {
    /**
     * 三方协议 数据访问对象
     */
    private IProtocolDao protocolDao;

    /**
     * 注入 三方协议 数据访问对象
     *
     * @param protocolDao 三方协议 数据访问对象
     */
    public void setProtocolDao(IProtocolDao protocolDao) {
        this.protocolDao = protocolDao;
    }

    @Override
    public Protocol getProtocolById(String id) {
        return protocolDao.getProtocolById(id);
    }

    @Override
    public void addProtocol(Protocol protocol) {
        protocolDao.addProtocol(protocol);
    }

    @Override
    public void updateProtocol(Protocol protocol) {
        protocolDao.updateProtocol(protocol);
    }

    @Override
    public void deleteProtocolById(String id) {
        protocolDao.deleteProtocolById(id);
    }

    @Override
    public List<Protocol> getProtocols(int pageSize, int pageNo) {
        int firstResult = (pageNo - 1) * pageSize;
        int maxResults = pageSize;
        return protocolDao.getProtocols(firstResult, maxResults);
    }

    @Override
    public int getProtocolsCount() {
        return protocolDao.getProtocolsCount();
    }

}
