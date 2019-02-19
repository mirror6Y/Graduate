package com.thunisoft.graduate.controller;

import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Protocol;
import com.thunisoft.graduate.service.IProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addProtocol() {
        Protocol protocol = new Protocol(201512031, "91210200241765653R", "大连市高新园区人才交流中心", "", "人事代理部", "", "", "");
        protocolService.addProtocol(protocol);
    }

    /**
     * 删除协议信息
     * url:"http://localhost:8088/protocol/deleteProtocolById/{id}"
     */
    @DeleteMapping("/deleteProtocolById/{id}")
    public void deleteProtocolById(@PathVariable("id") String id) {
        protocolService.deleteProtocolById(id);
    }

    /**
     * 修改协议信息
     * url:"http://localhost:8088/protocol/updateProtocol"
     */
    @PutMapping("/updateProtocol")
    public void updateProtocol() {
        Protocol protocol = new Protocol("ad11511762a14a248292be03e01f9c81", 201512031, "91210200241765653R", "大连市高新园区人才交流中心", "", "人事代理部", "116023", "", "");
        protocolService.updateProtocol(protocol);
    }

    /**
     * 通过ID查找协议信息
     * url:"http://localhost:8088/protocol/getProtocolById/{id}"
     *
     * @return Protocol
     */
    @GetMapping("/getProtocolById/{id}")
    public String getProtocolById(@PathVariable("id") String id) {
        Integer presence=protocolService.getProtocolCountById(id);
        if(presence>0){
            protocolService.getProtocolById(id);
            return Constants.C_CURD_SUCCESS;
        }else{
            return "您输入的编号错误，尚未查询到该协议的信息";
        }
    }

}
