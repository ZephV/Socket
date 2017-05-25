package com.imooc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  /**
   * 基于TCP的Socket通信客户端
   *
   */

  public static void main(String[] args) {
    try {
      //创建客户端Socket，指定地址和端口号
      Socket socket = new Socket("localhost", 8888);
      //获取输出流，想服务器发送信息
      OutputStream os = socket.getOutputStream();
      PrintWriter pw = new PrintWriter(os);
      pw.write("用户名：zeph;密码：123");
      pw.flush();
      socket.shutdownOutput();//关闭socket输出流
      //获取输入流，接受服务器的信息
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String info;
      while ((info = br.readLine()) != null) {
        System.out.println("This is Client, The Server said :" + info);
      }
      socket.shutdownInput();
      //关闭资源
      br.close();
      isr.close();
      is.close();
      pw.close();
      os.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
