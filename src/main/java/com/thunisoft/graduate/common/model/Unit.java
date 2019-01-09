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
 * <p> Description: 单位信息</p>
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
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织机构代码
     */
    private String id;
    /**
     * 单位名称
     */
    private String name;
    /**
     * 通讯地址
     */
    private String address;
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * 单位所在地
     */
    private String location;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系方式
     */
    private String contactTel;

}
