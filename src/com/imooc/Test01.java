package com.imooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 了解什么是InetAddress
 */
public class Test01 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名： " + address.getHostName());
        System.out.println("IP地址： " + address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println("字节数组形式的IP" + Arrays.toString(bytes));
        System.out.println(address);
    }
}
