package com.example.springboot.common.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.util.Map;
import java.util.Set;


@Component
public class RestTemplateUtil {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 发送get请求返回json数据
     *
     * @param url
     * @param params
     * @param headerMap
     * @return
     * @throws Exception
     */
    public ResponseEntity<String> getRequestAndReturnJosn(String url, Map<String, Object> params, Map<String, String> headerMap) throws Exception {
        if (StringUtils.isBlank(url)) {
            throw new Exception("sendGetRequestAndReturnJosn参数url不能为空");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        if (null != headerMap && !headerMap.isEmpty()) {
            Set<Map.Entry<String, String>> entries = headerMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                headers.add(entry.getKey(), entry.getValue());
            }
        }
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url);
        if (null != params && !params.isEmpty()) {
            Set<Map.Entry<String, Object>> entries = params.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                builder.queryParam(entry.getKey(), entry.getValue());
            }
        }

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
        return result;
    }


    /**
     * 发送post请求返回json数据
     *
     * @param url
     * @param headerMap
     * @return
     * @throws Exception
     */
    public ResponseEntity<String> postJsonDataAndReturnJosn(String url, String json, Map<String, String> headerMap) throws Exception {
        if (StringUtils.isBlank(url)) {
            //throw new SuperCodeException("postJsonDataAndReturnJosn参数url不能为空", 500);
            throw new Exception("postJsonDataAndReturnJosn参数url不能为空");
        }
        HttpHeaders headers = new HttpHeaders();
        //默认值 发送json数据
        headers.add("content-Type", "application/json");
        if (null != headerMap && !headerMap.isEmpty()) {
            Set<Map.Entry<String, String>> entries = headerMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                headers.add(entry.getKey(), entry.getValue());
            }
        }
        HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> result = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity, String.class);
        return result;
    }

    /**
     * 上传文件
     *
     * @param url
     * @param fileParamName
     * @param params
     * @param headerMap
     * @return
     * @throws Exception
     */
    public ResponseEntity<String> uploadFile(String url, String fileParamName, Map<String, Object> params, Map<String, String> headerMap) throws Exception {
        if (StringUtils.isBlank(url)) {
            throw new Exception("postJsonDataAndReturnJosn参数url不能为空");
        }
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
        if (null != params && !params.isEmpty()) {
            Object file = params.remove(fileParamName);
            if (null == file) {
                throw new Exception("文件不存在");
            }
            FileSystemResource fs = new FileSystemResource((File) file);
            param.add(fileParamName, fs);

            Set<Map.Entry<String, Object>> entries = params.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                param.add(entry.getKey(), entry.getValue());
            }
        }

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        if (null != headerMap && !headerMap.isEmpty()) {
            Set<Map.Entry<String, String>> entries = headerMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                headers.add(entry.getKey(), entry.getValue());
            }
        }
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, httpEntity, String.class);
        return responseEntity;
    }

}
