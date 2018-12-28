/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.web.artery.eform.unit;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.graduate.common.model.Unit;
import com.thunisoft.graduate.service.IUnitService;
import com.thunisoft.graduate.web.artery.eform.BaseLogic;
import com.thunisoft.graduate.web.common.MapResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * unitDetail 服务器端逻辑类
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @date 2018-12-24 16:30:40
 * @id unitDetail
 */
public class UnitDetail extends BaseLogic {
    /**
     * 单位信息 服务
     */
    @Autowired
    private IUnitService unitService;

    /**
     * 数据源（rs1） 查询方法
     *
     * @param qp 查询参数，只在分页查询时可用，否则为null
     * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
     */
    public Unit ds_rs1(IQueryInfo qp) {
        String id = ArteryParamUtil.getString("unit.id");
        if (StringUtils.isNotBlank(id)) {
            return unitService.getUnitById(id);
        }
        return null;
    }

    /**
     * 保存按钮点击时脚本
     *
     * @param item 保存按钮控件对象
     */
    public Object jqButton_save_onClickServer(Item item) {
        Unit unit = (Unit) ArteryParamUtil.getPojo(Unit.class, "unit");
        try {
            if (StringUtils.isBlank(unit.getId())) {
                unit.setId(null);

                unitService.addUnit(unit);
            } else {
                unitService.updateUnit(unit);
            }
            return MapResult.success();
        } catch (Exception e) {
            logger.error("保存单位信息出错", e);
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
