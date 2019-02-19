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
    public void addUnit() {
        Unit unit = new Unit("91210200241765653R", "大连华信计算机技术股份有限公司", "辽宁省大连高新技术产业园区黄浦路977号", "116023", "大连", "", "");
        unitService.addUnit(unit);
    }

    /**
     * 删除单位信息
     * url:"http://localhost:8088/unit/deleteUnitById/{id}"
     */
    @ResponseBody
    @DeleteMapping("/deleteUnitById/{id}")
    public void deleteUnitById(@PathVariable("id") String id) {
        unitService.deleteUnitById(id);
    }

    /**
     * 修改单位信息
     * url:"http://localhost:8088/unit/updateUnit"
     */
    @ResponseBody
    @PutMapping("/updateUnit")
    public void updateUnit() {
        Unit unit = new Unit("91210200241765653R", "大连华信计算机技术股份有限公司", "辽宁省大连高新技术产业园区黄浦路977号", "116023", "大连", "张三", "");
        unitService.updateUnit(unit);
    }

    /**
     * 通过ID查找单位信息
     * url:"http://localhost:8088/unit/getUnitById/{id}"
     *
     * @return Unit
     */
    @GetMapping("/getUnitById/{id}")
    public String getUnitById(@PathVariable("id") String id) {
        Integer presence = unitService.getUnitsCountById(id);
        if (presence > 0) {
            unitService.getUnitById(id);
            return Constants.C_CURD_SUCCESS;
        } else {
            return "您输入的组织机构代码错误，尚未查询到该单位的信息";
        }
    }

}
