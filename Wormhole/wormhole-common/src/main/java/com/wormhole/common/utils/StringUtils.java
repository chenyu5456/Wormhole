package com.wormhole.common.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: ChenYu
 * @Date: 2019/2/25 9:05
 * @Description:字符串工具类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 空字符串
     */
    private static final String NULL_STR = "";

    /**
     * 下划线
     */
    private static final char SEPARA_TOP = '_';

    /**
     * 获取参数不为空值
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static<T> T nvl(T value, T defaultValue){
        return value != null ? value : defaultValue;
    }

    /**
     * 判断一个Collection是否为空， 包含List，Set，Queue
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll){
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * 判断一个Collection是否非空，包含List，Set，Queue
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll){
        return !isEmpty(coll);
    }

    /**
     * 判断一个对象数组是否为空
     * @param objects 要判断的对象数组
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects){
        return isNull(objects) || objects.length == 0;
    }

    /**
     * 判断一个对象数组是否非空
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects){
        return !isEmpty(objects);
    }

    /**
     * 判断一个Map是否为空
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map){
        return isNull(map) || map.isEmpty();
    }

    /**
     * 判断一个对象数组是否非空
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map){
        return !isEmpty(map);
    }

    /**
     * 判断一个Map是否为空
     * @param str 要判断的String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str){
        return isNull(str) || NULL_STR.equals(str.trim());
    }

    /**
     * 判断一个字符串是否为非空串
     * @param str 要判断的String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 判断一个对象是否为空
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 判断一个对象是否非空
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object){
        return !isNull(object);
    }

    /**
     * 判断一个对象是否是数组类型（Java基本型别的数组）
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object){
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去空格
     * @param str
     * @return
     */
    public static String trim(String str){
        return (str == null ? "" : str.trim());
    }

    /**
     * 截取字符串
     * @param str 字符串
     * @param start 开始标识
     * @return 返回值
     */
    public static String substring(final String str, int start){
        if(str == null){
            return NULL_STR;
        }
        if(start < 0){
            start = str.length() + start;
        }
        if(start < 0){
            start = 0;
        }
        if(start > str.length()){
            return NULL_STR;
        }
        return str.substring(start);
    }

    /**
     * 截取字符串
     * @param str 字符串
     * @param start 开始标识
     * @param end 结束标识
     * @return 返回值
     */
    public static String substring(final String str, int start, int end){
        if(str == null){
            return NULL_STR;
        }

        if(end < 0){
            end = str.length() + end;
        }

        if (start < 0){
            start = str.length() + start;
        }
        if (end > str.length()){
            end = str.length();
        }
        if(start > end){
            return NULL_STR;
        }
        if(start < 0){
            start = 0;
        }
        if (end < 0){
            end = 0;
        }
        return str.substring(start, end);
    }

}
