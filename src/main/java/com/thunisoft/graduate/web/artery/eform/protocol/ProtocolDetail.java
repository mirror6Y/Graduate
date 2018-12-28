/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.web.artery.eform.protocol;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.graduate.common.model.Protocol;
import com.thunisoft.graduate.service.IProtocolService;
import com.thunisoft.graduate.web.artery.eform.BaseLogic;
import com.thunisoft.graduate.web.common.MapResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * protocolDetail 服务器端逻辑类
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @date 2018-12-24 16:30:40
 * @id protocolDetail
 */
public class ProtocolDetail extends BaseLogic {
    /**
     * 三方协议 服务
     */
    @Autowired
    private IProtocolService protocolService;

    /**
     * 数据源（rs1） 查询方法
     *
     * @param qp 查询参数，只在分页查询时可用，否则为null
     * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
     */
    public Protocol ds_rs1(IQueryInfo qp) {
        String id = ArteryParamUtil.getString("protocol.id");
        if (StringUtils.isNotBlank(id)) {
            return protocolService.getProtocolById(id);
        }
        return null;
    }

    /**
     * 保存按钮点击时脚本
     *
     * @param item 保存按钮控件对象
     */
    public Object jqButton_save_onClickServer(Item item) {
        Protocol protocol = (Protocol) ArteryParamUtil.getPojo(Protocol.class, "protocol");
        try {
            if (StringUtils.isBlank(protocol.getId())) {
                protocol.setId(null);

                protocolService.addProtocol(protocol);
            } else {
                protocolService.updateProtocol(protocol);
            }
            return MapResult.success();
        } catch (Exception e) {
            logger.error("保存三方协议出错", e);
            return MapResult.failure();
        }
    }
    
    /**
     *  “保存”按钮生成时脚本
     * @param item 控件对象
     */
    public void jqButton_save_onShow(Item item) {
        // 只在新建和编辑状态生成“保存”按钮
        item.set("show", context.isInsert() || context.isUpdate());
    }
}
