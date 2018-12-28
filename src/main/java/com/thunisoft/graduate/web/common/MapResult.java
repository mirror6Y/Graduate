/**
 * MapResult.java
 */
package com.thunisoft.graduate.web.common;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * <p> Description: Map存放的页面返回结果，提供一些实用方法。</p>
 *
 * <p> CreationTime: 2010-10-25 下午06:17:06
 * <br>Copyright: &copy;2010 <a href="http://www.thunisoft.com">Thunisoft</a>
 * <br>Email: <a href="mailto:anyx@thunisoft.com">anyx@thunisoft.com</a></p>
 * @author anyx
 * @version 1.5
 */
public final class MapResult extends HashMap<String, Object> {
    /**
     * 序列化版本唯一标识
     */
    private static final long serialVersionUID = -6935447157756023439L;
    /**
     * 表示是否成功的关键字
     * @since Version 1.2
     */
    public static final String KEY_SUCCESS = "success";
    /**
     * 表示消息的关键字
     * @since Version 1.2
     */
    public static final String KEY_MESSAGE = "msg";

    /**
     * 构造方法，私有。外部调用{@link #blankResult()}获得本类实例。
     */
    private MapResult() {
    }

    /**
     * 设置返回消息，客户端js通过回调函数的result参数的 .msg 属性获取此处设置的值。
     * 如果之前已经设置过则覆盖前值。<br>
     * 为了方便链式调用，此方法返回调用者自身。
     * @param msg 返回消息
     * @return 调用者自身
     */
    public MapResult setMessage(String msg) {
        super.put(KEY_MESSAGE, msg);
        return this;
    }

    /**
     * 设置是否成功的标志，客户端js通过回调函数的result参数的 .success 属性获取此处设置的值。
     * 如果之前已经设置过则覆盖前值。<br>
     * 为了方便链式调用，此方法返回调用者自身。
     * @param success 是否成功
     * @return 调用者自身
     */
    public MapResult setSuccess(boolean success) {
        super.put(KEY_SUCCESS, Boolean.valueOf(success));
        return this;
    }

    /**
     * 清除所有设置过的属性。为了方便链式调用，此方法返回调用者自身。
     * @return 调用者自身
     */
    public MapResult clearAll() {
        super.clear();
        return this;
    }

    /**
     * 获取一个全新的空结果对象
     * @return 空结果对象
     */
    public static MapResult blankResult() {
        return new MapResult();
    }

    /**
     * 用指定的success和msg初始化一个结果对象
     * @param success 是否成功
     * @param msg 消息
     * @return 结果对象
     */
    public static MapResult result(boolean success, String msg) {
        return blankResult().setMessage(msg).setSuccess(success);
    }

    /**
     * 用指定的msg初始化一个表示成功结果对象
     * @param msg 消息
     * @return 表示成功的结果对象
     * @since Version 1.1
     */
    public static MapResult success(String msg) {
        return result(true, msg);
    }

    /**
     * 用指定的格式及参数格式化消息并初始化一个表示成功结果对象。<code>format</code> 参数格式请参见{@link String#format(String, Object...)}。<br/>
     * 示例：
     * <pre>
     * MapResult.success("成功处理%d个任务", taskCount);
     * </pre>
     * @param format 消息格式
     * @param args 格式化参数
     * @return 表示成功的结果对象
     * @since Version 1.5
     *
     * @see String#format(String, Object...)
     */
    public static MapResult success(String format, Object... args) {
        return result(true, String.format(format, args));
    }

    /**
     * 用指定的msg初始化一个表示成功结果对象
     * @return 表示成功的结果对象
     * @since Version 1.1
     */
    public static MapResult success() {
        return success(null);
    }

    /**
     * 用指定的msg初始化一个表示失败结果对象
     * @param msg 消息
     * @return 表示失败的结果对象
     * @since Version 1.1
     */
    public static MapResult failure(String msg) {
        return result(false, msg);
    }

    /**
     * 用指定的格式及参数格式化消息并初始化一个表示失败结果对象。<code>format</code> 参数格式请参见{@link String#format(String, Object...)}。<br/>
     * 示例：
     * <pre>
     * MapResult.failure("有%d个任务未处理", taskCount);
     * </pre>
     * @param format 消息格式
     * @param args 格式化参数
     * @return 表示失败的结果对象
     * @since Version 1.5
     *
     * @see String#format(String, Object...)
     */
    public static MapResult failure(String format, Object... args) {
        return result(false, String.format(format, args));
    }

    /**
     * 用指定的msg初始化一个表示失败结果对象
     * @return 表示失败的结果对象
     * @since Version 1.1
     */
    public static MapResult failure() {
        return failure(null);
    }

    /**
     * 生成json字符串
     * @return 代表当前对象的json字符串
     */
    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    /**
     * 设置一个值到结果对象，如果已设置过相同的key则覆盖之前的值
     * @param key key
     * @param value value
     * @return 调用者自身
     */
    public MapResult set(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 移除一个值
     * @param key 键值
     * @return 调用者自身
     */
    public MapResult remove(String key) {
        super.remove(key);
        return this;
    }
    
    /**
     * 返回结果同 {@link #toJSONString()} 方法
     */
    @Override
    public String toString() {
        return toJSONString();
    }

}
