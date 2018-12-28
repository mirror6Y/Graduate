/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.web.artery.eform.graduate;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.graduate.common.model.Graduate;
import com.thunisoft.graduate.service.IGraduateService;
import com.thunisoft.graduate.web.artery.eform.BaseLogic;
import com.thunisoft.graduate.web.common.MapResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * graduateDetail 服务器端逻辑类
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @date 2018-12-24 16:30:40
 * @id graduateDetail
 */
public class GraduateDetail extends BaseLogic {
    /**
     * 毕业生信息 服务
     */
    @Autowired
    private IGraduateService graduateService;

    /**
     * 数据源（rs1） 查询方法
     *
     * @param qp 查询参数，只在分页查询时可用，否则为null
     * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
     */
    public Graduate ds_rs1(IQueryInfo qp) {
        String id = ArteryParamUtil.getString("graduate.id");
        if (StringUtils.isNotBlank(id)) {
            return graduateService.getGraduateById(id);
        }
        return null;
    }

    /**
     * 保存按钮点击时脚本
     *
     * @param item 保存按钮控件对象
     */
    public Object jqButton_save_onClickServer(Item item) {
        Graduate graduate = (Graduate) ArteryParamUtil.getPojo(Graduate.class, "mybatis/graduate");
        try {
            if (StringUtils.isBlank(graduate.getId())) {
                graduate.setId(null);

                graduateService.addGraduate(graduate);
            } else {
                graduateService.updateGraduate(graduate);
            }
            return MapResult.success();
        } catch (Exception e) {
            logger.error("保存毕业生信息出错", e);
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
