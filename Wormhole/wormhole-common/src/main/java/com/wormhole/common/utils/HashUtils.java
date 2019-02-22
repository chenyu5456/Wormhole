package com.wormhole.common.utils;

import com.google.common.base.Throwables;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @Author: ChenYu
 * @Date: 2019/2/22 12:16
 * @Description: MD5加密
 */
public class HashUtils {
    private static final HashFunction FUNCTION = Hashing.md5();

    private static final HashFunction MURMUR_FUNC = Hashing.murmur3_128();

    public static String encryPassword(String target){
        HashCode code = FUNCTION.hashString(target, Charset.forName("UTF-8"));
        return code.toString();
    }

    public static String hashString(String input){
        HashCode code = null;
        try {
            code = MURMUR_FUNC.hashBytes(input.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Throwables.propagateIfPossible(e);
        }
        return code.toString();
    }
}
