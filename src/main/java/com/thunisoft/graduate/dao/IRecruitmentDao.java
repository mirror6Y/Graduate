package com.thunisoft.graduate.dao;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Recruitment;

import java.util.Map;

public interface IRecruitmentDao {

    /**
     * 获取招聘信息列表
     *
     * @param firstResult 首记录索引，从0开始
     * @param maxResult  获取记录数量
     * @return 招聘信息列表
     */
    PageInfo<Recruitment> getRecruitments(int firstResult, int maxResult);

    /**
     * 获取招聘信息的数量
     *
     * @return 招聘信息数量
     */
    int getRecruitmentsCount();

    /**
     * 根据 主键 获取招聘信息
     *
     * @param id 招聘信息主键
     * @return 招聘信息
     */
    Recruitment getRecruitmentById(String id);

    /**
     * 根据 主键 获取招聘信息的数量
     *
     * @param id 招聘信息主键
     * @return 招聘信息
     */
    int getRecruitmentsCountById(String id);

    /**
     * 添加招聘信息
     *
     * @param recruitment 招聘信息
     */
    void addRecruitment(Recruitment recruitment);

    /**
     * 更新招聘信息
     *
     * @param recruitment 招聘信息
     */
    void updateRecruitment(Recruitment recruitment);

    /**
     * 删除招聘信息
     *
     * @param id 招聘信息主键
     */
    void deleteRecruitmentById(String id);
}
