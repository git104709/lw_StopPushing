package com.lunwei.lw_StopPushing;

import com.alibaba.fastjson.JSON;
import com.lunwei.lw_StopPushing.model.User;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * ClassName:    HttpClientTest
 * Package:    com.lunwei.lw_StopPushing
 * Description: httpClient方法封装
 * Datetime:    2020/1/13   10:45
 * Author:   zhoukaishun
 */
@Component
public class HttpClientUtil {

    @Autowired
    private HttpClientConfigure httpClientConfigure;

   /**
    * @description GET封装
    * @author zhoukaishun
    * @date 2020/1/13 13:12
    */
    public  void doGetHttp(List<NameValuePair> params,Boolean haveParams) {
        // 获得Http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 参数
        URI uri = null;
        try {
            // 设置uri信息,并将参数集合放入uri;
            if(haveParams){//有参调用
                uri = new URIBuilder().setScheme(httpClientConfigure.getScheme()).setHost(httpClientConfigure.getHost())
                        .setPort(httpClientConfigure.getPort()).setPath(httpClientConfigure.getMapPath().get("interface2"))
                        .setParameters(params).build();
            }else{//无参调用
                uri = new URIBuilder().setScheme(httpClientConfigure.getScheme()).setHost(httpClientConfigure.getHost())
                        .setPort(httpClientConfigure.getPort()).setPath(httpClientConfigure.getMapPath().get("interface1"))
                        .build();
            }
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        // 创建Get请求
        HttpGet httpGet = new HttpGet(uri);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 配置信息
            RequestConfig requestConfig = RequestConfig.custom()
                    // 设置连接超时时间(单位毫秒)
                    .setConnectTimeout(5000)
                    // 设置请求超时时间(单位毫秒)
                    .setConnectionRequestTimeout(5000)
                    // socket读写超时时间(单位毫秒)
                    .setSocketTimeout(5000)
                    // 设置是否允许重定向(默认为true)
                    .setRedirectsEnabled(true).build();

            // 将上面的配置信息 运用到这个Get请求里
            httpGet.setConfig(requestConfig);
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @description POST封装
     * @author zhoukaishun
     * @date 2020/1/13 14:01
     */
    public  void doPostHttp(User user, Boolean haveParam) {
        // 获得Http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        URI uri = null;
        try {
            // 设置uri信息,并将参数集合放入uri;
            uri = new URIBuilder().setScheme(httpClientConfigure.getScheme()).setHost(httpClientConfigure.getHost())
                    .setPort(httpClientConfigure.getPort())
                    .setPath(haveParam?httpClientConfigure.getMapPath().get("interface4"):httpClientConfigure.getMapPath().get("interface3"))
                    .build();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        // 创建Post请求
        HttpPost httpPost = new HttpPost(uri);
        if(haveParam){
            //入参
            // 利用阿里的fastjson，将Object转换为json字符串;
            // (需要导入com.alibaba.fastjson.JSON包)
            String jsonString = JSON.toJSONString(user);

            StringEntity entity = new StringEntity(jsonString, "UTF-8");
            // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
            httpPost.setEntity(entity);

            httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        }
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
