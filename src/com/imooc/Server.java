package com.imooc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  /**
   * 基于TCP的Socket通信服务端
   *
   */

  public static void main(String[] args) {

    try {
      //创建一个服务端Socket即ServerSocket，并指定他的端口
      ServerSocket serverSocket = new ServerSocket(8888);
      Socket socket;
      int count = 0;
      System.out.println("***服务器即将启动，等待客户端的连接***");
      //调用ServerSocket的accept方法，开始监听，等待客户端的连接
      while (true) {
        socket = serverSocket.accept();
        ServerThread serverThread = new ServerThread(socket);
        serverThread.start();
        count++;
        System.out.println("There are [" + count + "] Client in total.");
        InetAddress address = socket.getInetAddress();
        System.out.println("The Client IP :" + address.getHostAddress() );
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
