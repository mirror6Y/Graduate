/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.web.artery.eform.graduate;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.dataset.domain.impl.DefaultPagableData;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.graduate.common.model.Graduate;
import com.thunisoft.graduate.service.IGraduateService;
import com.thunisoft.graduate.web.artery.eform.BaseLogic;
import com.thunisoft.graduate.web.common.MapResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * graduateDetail 服务器端逻辑类
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @date 2018-12-24 16:30:40
 * @id graduateDetail
 */
public class GraduateList extends BaseLogic {
    /**
     * 毕业生信息 服务
     */
    @Autowired
    private IGraduateService graduateService;

    /**
     * 数据源(rs1)查询方法
     *
     * @param qp 查询参数，只在分页查询时可用，否则为null
     * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
     */
    public Object ds_rs1(IQueryInfo qp) {

        List<Graduate> graduates = graduateService.getGraduates(qp.getRowsPerPage(), qp.getCurrPageNo());
        
        int total = graduateService.getGraduatesCount();
        qp.setRowCount(total);

        DefaultPagableData pagableData = new DefaultPagableData();
        pagableData.setData(graduates);
        pagableData.setPageInfo(qp);

        return pagableData;
    }
    
    /**
     * 点击时脚本
     *
     * @param item 控件对象
     */
    public Object jqLink_delete_onClickServer(Item item) {
        String id = ArteryParamUtil.getString("graduate.id");
        if (StringUtils.isBlank(id)) {
            return MapResult.failure("请指定要删除的记录！");
        }
        try {
            graduateService.deleteGraduateById(id);
            return MapResult.success();
        } catch (Exception e) {
            logger.error("删除毕业生信息失败出错", e);
            return MapResult.failure();
        }
    }
}
