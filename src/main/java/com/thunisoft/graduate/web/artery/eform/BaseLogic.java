/*
 * (c) 2018 Thunisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.graduate.web.artery.eform;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> Description: 表单逻辑类基类，提供一些使用方法，所有业务表单都应继承此类</p>
 *
 * <p> CreationTime: 2018-12-24 16:30:40
 * <br>Copyright: &copy;2018 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:liuye@thunisoft.com">liuye@thunisoft.com</a></p>
 * @version 1.0
 * @author 由stage工具自动生成
 * @author liuye
 */
public class BaseLogic {
    /**
     * Artery逻辑类上下文。子类可直接使用
     */
    protected LogicClassContext context = LogicClassContext.getInstance();
    /**
     * 日志。子类可直接使用
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
