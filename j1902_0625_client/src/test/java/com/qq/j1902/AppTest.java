package com.qq.j1902;

import static org.junit.Assert.assertTrue;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void httpclient1() throws IOException {
       CloseableHttpClient httpClient = HttpClients.createDefault();
       String uri="http://localhost:8080/dept?name=aaa&loc=ddd";
       HttpGet httpGet = new HttpGet(uri);
       CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode==200){
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);
            System.out.println(string);
        }
    }
    @Test
    public void getBaidu() throws IOException {
        String uri="https://www.baidu.com";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode==200){
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);
            System.out.println(string);
        }
    }
    @Test
    public void httpclientPost() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri="http://localhost:8080/dept2";
        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> list=new ArrayList<>();
        list.add(new BasicNameValuePair("name","yanfabu"));
        list.add(new BasicNameValuePair("loc","shanghai"));
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list);
        httpPost.setEntity(formEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode==200){
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);
            System.out.println(string);
        }
    }
}
