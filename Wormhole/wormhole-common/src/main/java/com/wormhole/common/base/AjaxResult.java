package com.wormhole.common.base;

import java.util.HashMap;

/**
 * @Author: ChenYu
 * @Date: 2019/2/22 11:31
 * @Description:
 */
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult(){

    }

    /**
     * 返回错误消息
     * @return 错误消息
     */
    public static AjaxResult error(){
        return error(1, "操作失败");
    }

    /**
     * 返回错误消息
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg){
        return error(500, msg);
    }

    /**返回错误内容
     *
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(int code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功内容
     * @param msg 内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg){
        AjaxResult json = new AjaxResult();
        json.put("code", 200);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功信息
     * @return 成功信息
     */
    public static AjaxResult success(){
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回消息
     * @param key 键值
     * @param value 内容
     * @return 消息
     */
    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }
}
