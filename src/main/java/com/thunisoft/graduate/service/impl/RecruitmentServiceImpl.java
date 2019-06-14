package com.thunisoft.graduate.service.impl;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Recruitment;
import com.thunisoft.graduate.dao.IRecruitmentDao;
import com.thunisoft.graduate.service.IRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * @auther mirror6
 * @date 2019/6/1 20:13
 */
@Service
@Transactional
public class RecruitmentServiceImpl implements IRecruitmentService {

    private final IRecruitmentDao recruitmentDao;

    @Autowired
    public RecruitmentServiceImpl(IRecruitmentDao recruitmentDao) {
        this.recruitmentDao = recruitmentDao;
    }

    @Override
    public PageInfo<Recruitment> getRecruitments(int pageSize, int pageNo) {
        int firstResult = (pageNo - 1) * pageSize;
        int maxResults = pageSize;
        return recruitmentDao.getRecruitments(firstResult, maxResults);
    }

    @Override
    public int getRecruitmentsCount() {
        return recruitmentDao.getRecruitmentsCount();
    }

    @Override
    public Recruitment getRecruitmentById(String id) {
        return recruitmentDao.getRecruitmentById(id);
    }

    @Override
    public int getRecruitmentsCountById(String id) {
        return recruitmentDao.getRecruitmentsCountById(id);
    }

    @Override
    public void addRecruitment(Recruitment recruitment) {
        recruitmentDao.addRecruitment(recruitment);
    }

    @Override
    public void updateRecruitment(Recruitment recruitment) {
        recruitmentDao.updateRecruitment(recruitment);
    }

    @Override
    public void deleteRecruitmentById(String id) {
        recruitmentDao.deleteRecruitmentById(id);
    }
}
