package com.wormhole.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: ChenYu
 * @Date: 2019/3/26 16:09
 * @Description: Md5加密方法
 */
public class Md5Utils {
    //添加日记
    private static final Logger log = LoggerFactory.getLogger(Md5Utils.class);

    private static byte[] md5(String s){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(s.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return  digest;
        } catch (Exception e) {
            log.error("MD5 Error...", e);
        }
        return null;
    }

    private static String toHex(byte hash[]){
        if(hash == null){
            return null;
        }
        StringBuffer sbf = new StringBuffer(hash.length * 2);
        for(int i = 0; i < hash.length; i++){
            if((hash[i] & 0xff) < 0x10){
                sbf.append("0");
            }
            sbf.append(Long.toString((hash[i] & 0xff), 16));
        }
        return sbf.toString();
    }

    public static String hash(String s){
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("not supported charset...{}", e);
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(hash("123456"));
    }
}
