/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * <p> Description: 毕业生信息</p>
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
public class Graduate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 民族
     */
    private String people;
    /**
     * 政治面貌
     */
    private String politicalStatus;
    /**
     * 院系
     */
    private String college;
    /**
     * 专业
     */
    private String profession;
    /**
     * 班级
     */
    private String grade;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 毕业时间
     */
    private Date graduateTime;
    /**
     * 学历
     */
    private String education;
    /**
     * 学位类别
     */
    private String degree;
    /**
     * 家庭地址
     */
    private String address;

    //根据学号删除毕业生信息
    private Graduate(Integer id) {
        this.id = id;
    }

    /*
     * 静态工厂方法
     * 根据学号查找、删除毕业生信息
     */
    public static Graduate getInstance(Integer id) {
        return new Graduate(id);
    }

    public static class Builder {

        private final Integer id;

        private String name;

        private String idCard;

        private Integer gender;

        private String people;

        private String politicalStatus;

        private String college;

        private String profession;

        private String grade;

        private String tel;

        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date graduateTime;

        private String education;

        private String degree;

        private String address;

        public Builder(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder idCard(String value) {
            idCard = value;
            return this;
        }

        public Builder gender(Integer value) {
            gender = value;
            return this;
        }

        public Builder people(String value) {
            people = value;
            return this;
        }

        public Builder politicalStatus(String value) {
            politicalStatus = value;
            return this;
        }

        public Builder college(String value) {
            college = value;
            return this;
        }

        public Builder profession(String value) {
            profession = value;
            return this;
        }

        public Builder grade(String value) {
            grade = value;
            return this;
        }

        public Builder tel(String value) {
            tel = value;
            return this;
        }

        public Builder graduateTime(Date value) {
            graduateTime = value;
            return this;
        }

        public Builder education(String value) {
            education = value;
            return this;
        }

        public Builder degree(String value) {
            degree = value;
            return this;
        }

        public Builder address(String value) {
            address = value;
            return this;
        }

    }

    public Graduate(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.idCard = builder.idCard;
        this.gender = builder.gender;
        this.people = builder.people;
        this.politicalStatus = builder.politicalStatus;
        this.college = builder.college;
        this.profession = builder.profession;
        this.grade = builder.grade;
        this.tel = builder.tel;
        this.graduateTime = builder.graduateTime;
        this.education = builder.education;
        this.degree = builder.degree;
        this.address = builder.address;
    }
}
