package com.imooc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 了解URL
 */
public class Test02 {

    public static void main(String[] args){
        try {
            URL imooc = new URL("http://www.imooc.com/");
            URL url = new URL(imooc,"/index.html?username=tom#test");
            System.out.println("协议:" + url.getProtocol());
            System.out.println("地址:" + url.getHost());
            System.out.println("端口:" + url.getPort());
            System.out.println("文件路径:" + url.getPath());
            System.out.println("文件:" + url.getFile());
            System.out.println("相对路径:" + url.getRef());
            System.out.println("查询字符串:" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
