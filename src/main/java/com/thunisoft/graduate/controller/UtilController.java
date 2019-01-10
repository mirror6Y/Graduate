package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Unit;
import com.thunisoft.graduate.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mirror6
 * @Date: 2019/1/9 16:57
 */
@RestController
@RequestMapping("/unit")
public class UtilController {

    /**
     * 构造器注入unitService
     */
    private final IUnitService unitService;

    @Autowired
    public UtilController(IUnitService unitService) {
        this.unitService = unitService;
    }

    /**
     * 添加单位信息
     * url:"http://localhost:8088/unit/addUnit"
     */
    @ResponseBody
    @PostMapping("/addUnit")
    public String addUnit() {
        Unit unit = new Unit("91210200241765653R", "大连华信计算机技术股份有限公司", "辽宁省大连高新技术产业园区黄浦路977号", "116023", "大连", "", "");
        String mark = unitService.addUnit(unit);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

    /**
     * 删除单位信息
     * url:"http://localhost:8088/unit/deleteUnitById/{id}"
     */
    @ResponseBody
    @DeleteMapping("/deleteUnitById/{id}")
    public String deleteUnitById(@PathVariable("id") String id) {
        String mark = unitService.deleteUnitById(id);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

    /**
     * 修改单位信息
     * url:"http://localhost:8088/unit/updateUnit"
     */
    @ResponseBody
    @PutMapping("/updateUnit")
    public String updateUnit() {
        Unit unit = new Unit("91210200241765653R", "大连华信计算机技术股份有限公司", "辽宁省大连高新技术产业园区黄浦路977号", "116023", "大连", "张三", "");
        String mark = unitService.updateUnit(unit);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

    /**
     * 通过ID查找单位信息
     * url:"http://localhost:8088/unit/getUnitById/{id}"
     *
     * @return Unit
     */
    @GetMapping("/getUnitById/{id}")
    public String getUnitById(@PathVariable("id") String id) {
        String mark = unitService.getUnitById(id);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

}
