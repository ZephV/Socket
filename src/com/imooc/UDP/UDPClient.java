package com.imooc.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

  /**
   * 基于UDP的Socket通信客户端
   */
  public static void main(String[] args) throws IOException {
    //定义服务器地址，端口号，数据
    InetAddress address =InetAddress.getLocalHost();
    int port = 8800;
    byte[] data ="用户名：admin；密码:123".getBytes();
    //创建数据报，包含发送的数据信息
    DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
    //创建DatagramSocket对象
    DatagramSocket socket = new DatagramSocket();
    //向服务器发送数据报
    socket.send(packet);

    byte[] data2 = new byte[1024];
    DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
    socket.receive(packet2);
    String reply = new String(data2,0, packet2.getLength());
    System.out.println("This is Client , Server said :" + reply);

    socket.close();
  }

}
