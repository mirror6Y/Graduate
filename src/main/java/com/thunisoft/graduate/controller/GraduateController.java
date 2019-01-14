package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Graduate;
import com.thunisoft.graduate.service.IGraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    @ResponseBody
    @PostMapping("/addGraduate")
    public String addGraduate() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Graduate graduate = null;
        try {
            graduate = new Graduate(201512031, "程宇浩", "", 1, "汉族", "共青团员", "", "软件工程",
                    "1502", "", format.parse("2019-07-01"), "本科", "学士", "安庆市");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String mark = graduateService.addGraduate(graduate);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

    /**
     * 删除单位信息
     * url:"http://localhost:8088/graduate/deleteGraduateById/{id}"
     */
    @ResponseBody
    @DeleteMapping("/deleteGraduateById/{id}")
    public String deleteGraduateById(@PathVariable("id") Integer id) {
        String mark = graduateService.deleteGraduateById(id);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

    /**
     * 修改单位信息
     * url:"http://localhost:8088/graduate/updateGraduate"
     */
    @ResponseBody
    @PutMapping("/updateGraduate")
    public String updateGraduate() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Graduate graduate = null;
        try {
            graduate = new Graduate(201512031, "程宇浩", "", 1, "汉族", "共青团员", "计算机工程学院", "软件工程",
                    "1502", "", format.parse("2019-07-01"), "本科", "学士", "安庆市");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String mark = graduateService.updateGraduate(graduate);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }

    /**
     * 通过ID查找单位信息
     * url:"http://localhost:8088/graduate/getGraduateById/{id}"
     *
     * @return Graduate
     */
    @GetMapping("/getGraduateById/{id}")
    public String getGraduateById(@PathVariable("id") Integer id) {
        String mark = graduateService.getGraduateById(id);
        return Constants.C_CURD_SUCCESS.equals(mark) ? Constants.C_SUCCESS : Constants.C_FAIL;
    }


}
