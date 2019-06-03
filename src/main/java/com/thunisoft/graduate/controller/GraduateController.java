package com.thunisoft.graduate.controller;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Graduate;
import com.thunisoft.graduate.service.IGraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mirror6
 * @Date: 2019/1/11 15:25
 */

@RestController
@RequestMapping("/graduate")
public class GraduateController {

    private final IGraduateService graduateService;

    /**
     * 构造器注入graduateService
     */
    @Autowired
    public GraduateController(IGraduateService graduateService) {
        this.graduateService = graduateService;
    }

    /**
     * 添加单位信息
     * url:"http://localhost:8088/graduate/addGraduate"
     */
    @PostMapping("/addGraduate")
    public String addGraduate(Graduate graduate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(graduate.getGraduateTime());
        graduateService.addGraduate(graduate);
        return Constants.C_SUCCESS;
    }

    /**
     * 删除单位信息
     * url:"http://localhost:8088/graduate/deleteGraduateById/{id}"
     */
    @DeleteMapping("/deleteGraduateById/{id}")
    public void deleteGraduateById(@PathVariable("id") Integer id) {
        graduateService.deleteGraduateById(id);
    }

    /**
     * 修改单位信息
     * url:"http://localhost:8088/graduate/updateGraduate"
     */
    @PutMapping("/updateGraduate")
    public void updateGraduate() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Graduate graduate = null;
        try
        {
            graduate = new Graduate(201512031, "程宇浩", "", 1, "汉族", "共青团员", "计算机工程学院", "软件工程",
                    "1502", "", format.parse("2019-07-01"), "本科", "学士", "安庆市");
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        graduateService.updateGraduate(graduate);
    }

    /**
     * 通过ID查找单位信息
     * url:"http://localhost:8088/graduate/getGraduateById/{id}"
     *
     * @return Graduate
     */
    @GetMapping("/getGraduateById/{id}/{operation}")
    public ModelAndView getGraduateById(Model model, @PathVariable("id") Integer id, @PathVariable("operation") String operation) {
        Integer presence = graduateService.getGraduateCountById(id);
        if (presence > 0)
        {
            Graduate graduate = graduateService.getGraduateById(id);
            if ("update".equals(operation))
            {
                model.addAttribute("graduateUpdate", graduate);
                return new ModelAndView("graduate/graduateUpdate");
            } else if ("delete".equals(operation))
            {
                model.addAttribute("graduateDelete", graduate);
                return new ModelAndView("graduate/graduateDelete");
            } else
            {
                model.addAttribute("graduateInfo", graduate);
                return new ModelAndView("graduate/graduateInfo");
            }
        } else
        {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/getGraduates")
    public ModelAndView getGraduates(Model model, @RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Graduate graduate) {
        //列表过滤条件
        Map map = new HashMap();
        map.put("college", graduate.getCollege());
        map.put("name", graduate.getName());
        //教师列表
        PageInfo<Graduate> pageInfo = graduateService.getGraduates(pageSize, pageNum, map);
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
        return new ModelAndView("graduate/graduate");
    }


}
