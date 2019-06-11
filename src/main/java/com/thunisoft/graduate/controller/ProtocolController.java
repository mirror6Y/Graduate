package com.thunisoft.graduate.controller;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Protocol;
import com.thunisoft.graduate.service.IProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mirror6
 * @Date: 2019/1/14 15:06
 */

@RestController
@RequestMapping("/protocol")
public class ProtocolController {

    private final IProtocolService protocolService;

    @Autowired
    public ProtocolController(IProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    /**
     * 添加协议信息
     * url:"http://localhost:8088/protocol/addProtocol"
     */
    @PostMapping("/addProtocol")
    public String addProtocol(Protocol protocol) {
        protocolService.addProtocol(protocol);
        return Constants.C_SUCCESS;
    }

    /**
     * 删除协议信息
     * url:"http://localhost:8088/protocol/deleteProtocolById/{id}"
     */
    @DeleteMapping("/deleteProtocolById/{id}")
    public String deleteProtocolById(@PathVariable("id") String id) {
        protocolService.deleteProtocolById(id);
        return Constants.C_SUCCESS;
    }

    /**
     * 修改协议信息
     * url:"http://localhost:8088/protocol/updateProtocol"
     */
    @PutMapping("/updateProtocol")
    public String updateProtocol(Protocol protocol) {
        protocolService.updateProtocol(protocol);
        return Constants.C_SUCCESS;
    }

    /**
     * 通过ID查找协议信息
     * url:"http://localhost:8088/protocol/getProtocolById/{id}"
     *
     * @return Protocol
     */
    @GetMapping("/getProtocolById/{id}/{operation}")
    public ModelAndView getProtocolById(Model model, @PathVariable("id") String id, @PathVariable("operation") String operation) {
        int presence = protocolService.getProtocolCountById(id);
        if (presence > 0)
        {
            Protocol protocol = protocolService.getProtocolById(id);
            if ("update".equals(operation))
            {
                model.addAttribute("protocolUpdate", protocol);
                return new ModelAndView("protocol/protocolUpdate");
            } else if ("delete".equals(operation))
            {
                model.addAttribute("protocolDelete", protocol);
                return new ModelAndView("protocol/protocolDelete");
            } else
            {
                model.addAttribute("protocolInfo", protocol);
                return new ModelAndView("protocol/protocolInfo");
            }
        } else
        {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/getProtocols")
    public ModelAndView getTeachers(Model model, @RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Protocol protocol) {
        //列表过滤条件
        Map<String, Object> map = new HashMap<>();
//        map.put("graduateName", teacher.getCollege());
//        map.put("unitName", teacher.getName());
        //教师列表
        PageInfo<Protocol> pageInfo = protocolService.getProtocols(pageSize, pageNum, map);
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
        return new ModelAndView("protocol/protocol");
    }


}
