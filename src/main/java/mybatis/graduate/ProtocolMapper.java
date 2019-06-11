/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mybatis.graduate;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.model.Protocol;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p> Description: 三方协议 Mybatis数据访问映射接口</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 *
 * @author 由stage工具自动生成
 * @author liuye
 * @version 1.0
 */
public interface ProtocolMapper {

    /**
     * 获取三方协议列表
     *
     * @return 三方协议列表
     */
    List<Protocol> getProtocols(Map map);

    /**
     * 获取三方协议的数量
     *
     * @return 三方协议数量
     */
    int getProtocolsCount();

    /**
     * 根据 协议编号 获取三方协议
     *
     * @param id 三方协议 协议编号
     * @return 三方协议
     */

    Protocol getProtocolById(String id);

    /**
     * 根据 协议编号 获取三方协议的数量
     *
     * @param id 三方协议 协议编号
     * @return 三方协议的数量
     */
    int getProtocolCountById(String id);

    /**
     * 添加三方协议
     *
     * @param protocol 三方协议
     */
    void addProtocol(Protocol protocol);

    /**
     * 更新三方协议
     *
     * @param protocol 三方协议
     */
    void updateProtocol(Protocol protocol);


    /**
     * 删除三方协议
     *
     * @param id 三方协议 协议编号
     */
    void deleteProtocolById(String id);
}
