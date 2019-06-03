//package com.thunisoft.graduate.common.model;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
///**
// * @auther mirror6
// * @date 2019/6/1 16:53
// */
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@TableName(value = "t_recruitment")//表名和类名不一样时，使用TableName注释
//public class Recruitment {
//
//    /**
//     * 主键
//     */
//    @TableId(value = "c_id", type = IdType.UUID)
//    private String id;
//
//    /**
//     * 招聘标题
//     */
//    @TableField(value = "c_title")
//    private String title;
//
//    /**
//     * 招聘信息
//     */
//    @TableField(value = "c_info")
//    private String info;
//
//    /**
//     * 招聘地点
//     */
//    @TableField(value = "c_place")
//    private String place;
//
//    /**
//     * 薪资
//     */
//    @TableField(value = "n_salary")
//    private Integer salary;
//}
