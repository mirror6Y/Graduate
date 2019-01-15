/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


/**
 * <p> Description: 三方协议</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Protocol implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 协议编号
     */
    private String id;
    /**
     * 毕业生学号
     */
    private Integer graduateId;
    /**
     * 单位组织机构代码
     */
    private String unitId;
    /**
     * 档案接收单位名称
     */
    private String fileRecUnit;
    /**
     * 档案接收单位地址
     */
    private String fileRecAdd;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * 户口接收单位
     */
    private String accRecUnit;
    /**
     * 组织关系接收单位
     */
    private String orgRecUnit;

    /**
     * 添加协议信息
     *
     * @param graduateId  毕业生学号
     * @param unitId      单位统一社会信用代码
     * @param fileRecUnit 档案接收单位名称
     * @param fileRecAdd  档案接收单位地址
     * @param contact     联系人
     * @param zipCode     邮编
     * @param accRecUnit  户口接收单位
     * @param orgRecUnit  党、团组织关系接收单位
     */
    public Protocol(Integer graduateId, String unitId, String fileRecUnit, String fileRecAdd, String contact, String zipCode, String accRecUnit, String orgRecUnit) {
        this.graduateId = graduateId;
        this.unitId = unitId;
        this.fileRecUnit = fileRecUnit;
        this.fileRecAdd = fileRecAdd;
        this.contact = contact;
        this.zipCode = zipCode;
        this.accRecUnit = accRecUnit;
        this.orgRecUnit = orgRecUnit;
    }
}
