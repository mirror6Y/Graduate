//package mybatis.graduate;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.thunisoft.graduate.common.model.Recruitment;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Map;
//
//public interface RecruitmentMapper extends BaseMapper<Recruitment> {
//
//    @Override
//    IPage<Map<String, Object>> selectMapsPage(IPage<Recruitment> page, Wrapper<Recruitment> queryWrapper);
//
//    @Override
//    int insert(Recruitment entity);
//
//    @Override
//    int deleteById(Serializable id);
//
//    @Override
//    int updateById(Recruitment entity);
//
//    @Override
//    Recruitment selectById(Serializable id);
//
//}
