package com.thunisoft.graduate.controller;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Unit;
import com.thunisoft.graduate.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
    public String addUnit(Unit unit) {
        unitService.addUnit(unit);
        return Constants.C_SUCCESS;
    }

    /**
     * 删除单位信息
     * url:"http://localhost:8088/unit/deleteUnitById/{id}"
     */
    @ResponseBody
    @DeleteMapping("/deleteUnitById/{id}")
    public String deleteUnitById(@PathVariable("id") String id) {
        unitService.deleteUnitById(id);
        return Constants.C_SUCCESS;
    }

    /**
     * 修改单位信息
     * url:"http://localhost:8088/unit/updateUnit"
     */
    @ResponseBody
    @PutMapping("/updateUnit")
    public String updateUnit(Unit unit) {
        unitService.updateUnit(unit);
        return Constants.C_SUCCESS;
    }

    /**
     * 通过ID查找单位信息
     * url:"http://localhost:8088/unit/getUnitById/{id}"
     *
     * @return Unit
     */
    @GetMapping("/getUnitById/{id}/{operation}")
    public ModelAndView getUnitById(Model model, @PathVariable("id") String id, @PathVariable("operation") String operation) {
        Integer presence = unitService.getUnitsCountById(id);
        if (presence > 0)
        {
            Unit unit = unitService.getUnitById(id);
            if ("update".equals(operation))
            {
                model.addAttribute("unitUpdate", unit);
                return new ModelAndView("unit/unitUpdate");
            } else if ("delete".equals(operation))
            {
                model.addAttribute("unitDelete", unit);
                return new ModelAndView("unit/unitDelete");
            } else
            {
                model.addAttribute("unitInfo", unit);
                return new ModelAndView("unit/unitInfo");
            }
        } else
        {
            return new ModelAndView("error");
        }
    }


    @GetMapping("/getUnits")
    public ModelAndView getUnits(Model model, @RequestParam(defaultValue = "3") Integer
            pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Unit unit) {
        //列表过滤条件
        Map<String, Object> map = new HashMap<>();
        map.put("address", unit.getAddress());//根据地址过滤
        map.put("name", unit.getName());//根据名称过滤
        //教师列表
        PageInfo<Unit> pageInfo = unitService.getUnits(pageSize, pageNum, map);
        model.addAttribute("pageInfo", pageInfo);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        return new ModelAndView("unit/unit");
    }

}
