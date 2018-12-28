/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.common.model;

import lombok.Getter;
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

}
