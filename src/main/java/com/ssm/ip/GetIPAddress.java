package com.ssm.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class GetIPAddress {
	public static String getHostIp(){  
	    try{  
	        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();  //获取本机所有网络接口？
	        while (allNetInterfaces.hasMoreElements()){  					//如果有多条为true
	            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();  //遍历每一个接口？
	            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();  //获取本机ip？
	            while (addresses.hasMoreElements()){  
	                InetAddress ip = (InetAddress) addresses.nextElement();  //如果有多个地址就遍历下一个？
	                if (ip != null   
	                        && ip instanceof Inet4Address  //是否为ipV4地址？
	                        && !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255  
	                        && ip.getHostAddress().indexOf(":")==-1){  
	                    System.out.println("本机的IP = " + ip.getHostAddress());  
	                    return ip.getHostAddress();  
	                }   
	            }  
	        }  
	    }catch(Exception e){  
	        e.printStackTrace();  
	    }  
	    return null;  
	}  
} 
