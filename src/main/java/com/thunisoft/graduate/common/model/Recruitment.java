package com.thunisoft.graduate.common.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @auther mirror6
 * @date 2019/6/1 16:53
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Recruitment {

    /**
     * 主键
     */
    private String id;

    /**
     * 招聘标题
     */
    private String title;

    /**
     * 招聘信息
     */
    private String info;

    /**
     * 招聘地点
     */
    private String place;

    /**
     * 薪资
     */
    private Integer salary;
}
