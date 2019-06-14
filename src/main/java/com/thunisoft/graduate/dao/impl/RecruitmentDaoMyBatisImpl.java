package com.thunisoft.graduate.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Recruitment;
import com.thunisoft.graduate.dao.IRecruitmentDao;
import mybatis.graduate.RecruitmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @auther mirror6
 * @date 2019/6/11 19:16
 */
@Repository
public class RecruitmentDaoMyBatisImpl implements IRecruitmentDao {

    @Autowired
    private RecruitmentMapper recruitmentMapper;


    @Override
    public PageInfo<Recruitment> getRecruitments(int firstResult, int maxResults) {
        int pageNo = firstResult / maxResults + 1;
        PageHelper.startPage(pageNo, maxResults); //开始起始页
        List<Recruitment> recruitments = recruitmentMapper.getRecruitments();
        return new PageInfo<>(recruitments);
    }

    @Override
    public int getRecruitmentsCount() {
        return recruitmentMapper.getRecruitmentsCount();
    }

    @Override
    public Recruitment getRecruitmentById(String id) {
        return recruitmentMapper.getRecruitmentById(id);
    }

    @Override
    public int getRecruitmentsCountById(String id) {
        return recruitmentMapper.getRecruitmentCountById(id);
    }

    @Override
    public void addRecruitment(Recruitment recruitment) {
        if (recruitment.getId() == null)
        {
            recruitment.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        recruitmentMapper.addRecruitment(recruitment);
    }

    @Override
    public void updateRecruitment(Recruitment recruitment) {
        recruitmentMapper.updateRecruitment(recruitment);
    }

    @Override
    public void deleteRecruitmentById(String id) {
        recruitmentMapper.deleteRecruitmentById(id);
    }
}
