package com.imooc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

  Socket socket;

  public ServerThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    OutputStream os = null;
    PrintWriter pw = null;
    try {
      is = socket.getInputStream();
      isr = new InputStreamReader(is);
      br = new BufferedReader(isr);
      String info;
      while ((info = br.readLine()) != null) {
        System.out.println("This is Server,The Client said :" + info);
      }
      socket.shutdownInput();//关闭输入流
      //获取输出流，向客户端发送信息
      os = socket.getOutputStream();
      pw = new PrintWriter(os);
      pw.write("欢迎您的登陆");
      pw.flush();//刷新缓存
      socket.shutdownOutput();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (pw != null) {
          pw.close();
        }
        if (os != null) {
          os.close();
        }
        if (br != null) {
          br.close();
        }
        if (isr != null) {
          isr.close();
        }
        if (is != null) {
          is.close();
        }
        if (socket != null) {
          socket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}
