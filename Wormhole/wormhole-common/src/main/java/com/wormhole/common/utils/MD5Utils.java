package com.wormhole.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: ChenYu
 * @Date: 2019/2/22 14:10
 * @Description:Md5加密方法
 */
public class MD5Utils {
    private static final Logger log = LoggerFactory.getLogger(MD5Utils.class);

    private static byte[] md5(String target){
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(target.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.error("MD5 Error", e);
        }
        return null;
    }

    private static final String toHex(byte hash[]){
        if(hash == null){
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length*2);
        int i;
        for (i = 0; i < hash.length; i++){
            if((hash[i] & 0xff) < 0x10){
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String hash(String s){
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("not supported charset...{}", e);
            return s;
        }
    }
}
