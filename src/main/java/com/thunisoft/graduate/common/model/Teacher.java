/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.common.model;

import lombok.*;

import java.io.Serializable;


/**
 * <p> Description: 教师信息</p>
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
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工号
     */
    private Integer id;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 院系
     */
    private String college;
    /**
     * 办公室
     */
    private String office;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 权限
     */
    private String permission;

    /*
     *添加教师信息
     */
    public Teacher(Integer id, String name, Integer gender, String college, String office, String tel, String permission) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.office = office;
        this.tel = tel;
        this.permission = permission;
    }
}
