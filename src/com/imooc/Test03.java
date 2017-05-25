package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test03 {

  /**
   * 了解URL的openStream方法的使用
   *
   */

  public static void main(String[] args) {

    try {
      //创建一个URL实例
      URL url = new URL("https://www.baidu.com/");
      //通过openStream方法获取URL对象所表示资源的字节流
      InputStream is = url.openStream();
      //将字节流转换为字符流
      InputStreamReader isr = new InputStreamReader(is);
      //为字符流添加缓冲
      BufferedReader br = new BufferedReader(isr);
      //读取输入流
      String data = br.readLine();
      while(data != null){
        System.out.println(data);
        data = br.readLine();
      }
      br.close();
      isr.close();
      is.close();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
