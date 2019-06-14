package mybatis.graduate;

import com.thunisoft.graduate.common.model.Recruitment;

import java.util.List;
import java.util.Map;

public interface RecruitmentMapper {
    /**
     * 获取毕业生信息列表
     *
     * @return 招聘信息列表
     */
    List<Recruitment> getRecruitments();

    /**
     * 获取毕业生信息的数量
     *
     * @return 毕业生信息数量
     */
    int getRecruitmentsCount();

    /**
     * 根据 编号 获取毕业生信息
     *
     * @param id 毕业生信息 编号
     * @return 毕业生信息
     */
    Recruitment getRecruitmentById(String id);

    /**
     * 根据 编号 获取毕业生信息的数量
     *
     * @param id 毕业生信息 编号
     * @return 毕业生信息的数量
     */
    int getRecruitmentCountById(String id);

    /**
     * 添加毕业生信息
     *
     * @param recruitment 毕业生信息
     */
    void addRecruitment(Recruitment recruitment);

    /**
     * 更新毕业生信息
     *
     * @param recruitment 毕业生信息
     */
    void updateRecruitment(Recruitment recruitment);

    /**
     * 删除毕业生信息
     *
     * @param id 毕业生信息 编号
     */
    void deleteRecruitmentById(String id);


}
