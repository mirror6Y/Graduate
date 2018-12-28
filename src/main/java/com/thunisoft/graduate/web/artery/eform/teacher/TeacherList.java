/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.web.artery.eform.teacher;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.dataset.domain.impl.DefaultPagableData;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.graduate.common.model.Teacher;
import com.thunisoft.graduate.service.ITeacherService;
import com.thunisoft.graduate.web.artery.eform.BaseLogic;
import com.thunisoft.graduate.web.common.MapResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * teacherDetail 服务器端逻辑类
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @date 2018-12-24 16:30:40
 * @id teacherDetail
 */
public class TeacherList extends BaseLogic {
    /**
     * 教师信息 服务
     */
    @Autowired
    private ITeacherService teacherService;

    /**
     * 数据源(rs1)查询方法
     *
     * @param qp 查询参数，只在分页查询时可用，否则为null
     * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
     */
    public Object ds_rs1(IQueryInfo qp) {

        List<Teacher> teachers = teacherService.getTeachers(qp.getRowsPerPage(), qp.getCurrPageNo());
        
        int total = teacherService.getTeachersCount();
        qp.setRowCount(total);

        DefaultPagableData pagableData = new DefaultPagableData();
        pagableData.setData(teachers);
        pagableData.setPageInfo(qp);

        return pagableData;
    }
    
    /**
     * 点击时脚本
     *
     * @param item 控件对象
     */
    public Object jqLink_delete_onClickServer(Item item) {
        String id = ArteryParamUtil.getString("teacher.id");
        if (StringUtils.isBlank(id)) {
            return MapResult.failure("请指定要删除的记录！");
        }
        try {
            teacherService.deleteTeacherById(id);
            return MapResult.success();
        } catch (Exception e) {
            logger.error("删除教师信息失败出错", e);
            return MapResult.failure();
        }
    }
}
