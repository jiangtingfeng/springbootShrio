package com.example.springboot.common.util;


import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.StringReader;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


/**
 * RSA 公私钥 工具类
 */
@Slf4j
public class CertUtil {

    /**
     * 加签方法
     * @param: plain，明文
     * @param: priKey，私钥文本
     */
    public static byte[] sign(byte[] plain, String priKey) throws Exception {
        PrivateKey privateKey = getPrivateKey(priKey);
        Signature signature = Signature.getInstance("Sha256WithRSA");
        signature.initSign(privateKey);
        signature.update(plain);
        byte[] signed = signature.sign();
        return signed;
    }

    /**
     * 验签方法
     * @param: plain，明文
     * @param: signedData，秘文
     * @param: pubKey，公钥文本
     */
    public static boolean rsaCert(byte[] plain, byte[] signedData, String pubkey) throws Exception {
        PublicKey publicKey = getPublicKey(pubkey);
        Signature signature2 = Signature.getInstance("Sha256WithRSA");
        signature2.initVerify(publicKey);
        signature2.update(plain);
        return signature2.verify(signedData);
    }

    /**
     * 构造公钥数据
     * @param: pubKey，公钥文本
     */
    public static PublicKey getPublicKey(String pubKey) throws Exception{
        //1.获取公钥数据
        byte[] bytesPublicBase64 = readKeyDatas(pubKey);
        //2.对读取回来的数据进行Base64解码
        byte[] bytesPublic = Base64.getDecoder().decode(bytesPublicBase64);
        //3.把解码后的数据,重新封装成一个PublicKey对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytesPublic);
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            log.error("[Notary API Error] " + e.getMessage(), e);
            throw e;
        } catch (InvalidKeySpecException e) {
            log.error("[Notary API Error] " + e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 构造私钥数据
     * @param: pubKey，私钥文本
     */
    public static PrivateKey getPrivateKey(String priKey) throws Exception{
        //1.读取私钥文件,获取私钥数据
        byte[] bytesPrivateBase64 = readKeyDatas(priKey);
        //2.对读取回来的数据进行Base64解码
        byte[] bytesPrivate = Base64.getDecoder().decode(bytesPrivateBase64);
        //3.把解码后的数据,重新封装成一个PrivateKey对象
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytesPrivate);
        KeyFactory keyFactory=null;
        keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    private static byte[] readKeyDatas(String key) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new StringReader(key));
        String str=null;
        StringBuilder stringBuilder=new StringBuilder();
        while ((str=bufferedReader.readLine())!=null){
            if(str.contains("---")){
                continue;
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString().getBytes("UTF-8");
    }

    public static void main(String[] args) throws Exception {
        String text= "123";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJQW367mlqNOaxA3j9ZDh1nn0OnytC/g9wQMjUYKjhkbRU9aq3J5NnZXWcUpjFgrsbEalEe65WUrdXrSPPs6y6tFHATx2GI8hGbcQ756bSXiqmoGjTsLEB46D2WDQe4e6jJv8f7fK62SVZul2Ip4dvwh/N1Y6wOUoQX0mO2siR8RAgMBAAECgYEAjlWF3MdIleGzSbz9hMUW/LSwuYtK4JHrGXsu9dkDRuJNNb5B9x7F1+yRHc2XVM96VGzlhCQAg8LHgas8bYPPaGkGLfVC96FnM4/ECfdi5bXfq/wgy8kwXGclkQGUQFzaJBAGChHmMkzSR2Uky5r6bWYHxIxpyRWWCdEbhgtotSECQQDyg7IOMRBRMeWkEHtMwK1ptDj+KzWJzaXRoANxbvF94fGkShNfhd2ICK8Cai+j60GU3ZUBKpLwSvTVeIOiRfCNAkEAnFL+Zevzls8qCB+FGd6mbTgF44ByLABnx41iSNChPxnKSvG9kvnEz5qW0oqx7ws6MAx4rk7wVvVmVXFC8HXRlQJAamQKJh2yKdy5AOvWG8rfiOLuqdqs5yKX30nSmN3yBaasysVQkHR6xmYA2Q9ajQ/1OminKNbTlaVcmZYAMZ17NQJAEN3HgvmtQ4VAlLXJ55ulOz2DLSOrreGxUM+JXi/cZfGDaQiiGpyGRpv4T+kU/6Snd42w66WquscpbmiU/1rG7QJBAID8Q5llcD/9wnwr4OSs+llO5FMzbi+JN87o9J0iWpwllb0CMPIZzSfKrJgKGsTrcZ/FDJgr2UDR0hRbRhQ6lZc=";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUFt+u5pajTmsQN4/WQ4dZ59Dp8rQv4PcEDI1GCo4ZG0VPWqtyeTZ2V1nFKYxYK7GxGpRHuuVlK3V60jz7OsurRRwE8dhiPIRm3EO+em0l4qpqBo07CxAeOg9lg0HuHuoyb/H+3yutklWbpdiKeHb8IfzdWOsDlKEF9JjtrIkfEQIDAQAB";
        byte[] sign = sign(text.getBytes("UTF-8"), privateKey);
        boolean b = rsaCert(text.getBytes("UTF-8"), sign, publicKey);
        System.out.println(b);
    }
}
