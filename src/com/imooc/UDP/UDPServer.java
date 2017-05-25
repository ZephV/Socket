package com.imooc.UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

  /**
   * 基于UDP的Socket通信服务端
   */

  public static void main(String[] args) throws IOException {
    //创建服务器端DatagramSocket,指定端口号
    DatagramSocket socket = new DatagramSocket(8800);
    //创建数据报，用于接收用户发送的信息
    byte[] data = new byte[1024];//创建字节数组，指定接收数据报的大小
    DatagramPacket packet = new DatagramPacket(data, data.length);
    //接受客户端发送的信息
    System.out.println("***服务端已经启动，等待客户端发送信息***");
    socket.receive(packet);//此方法在接收到数据之前会一直阻塞
    //读取数据
    String info = new String(data, 0, packet.getLength());
    System.out.println("This is Server,Client said :" + info);

    //
    InetAddress address =packet.getAddress();
    int port = packet.getPort();
    byte[] data2 = "欢迎您！".getBytes();

    DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
    socket.send(packet2);
    socket.close();
  }

}