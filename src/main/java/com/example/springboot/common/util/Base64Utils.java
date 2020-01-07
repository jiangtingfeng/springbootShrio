package com.example.springboot.common.util;

import org.apache.commons.codec.binary.Base64;

/** */

/**
* <p>
* BASE64编码解码工具包
* </p>
*/
public class Base64Utils {
   
   /** *//**
    * <p>
    * BASE64字符串解码为二进制数据
    * </p>
    * 
    * @param base64
    * @return
    * @throws Exception
    */
   public static byte[] decode(String base64) throws Exception {
       return Base64.decodeBase64(base64.getBytes("UTF-8"));
   }
   
   /** *//**
    * <p>
    * 二进制数据编码为BASE64字符串
    * </p>
    * 
    * @param bytes
    * @return
    * @throws Exception
    */
   public static String encode(byte[] bytes) throws Exception {
       return new String(Base64.encodeBase64(bytes),"UTF-8");
   }
   
}
