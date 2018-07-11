package com.ssm.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class GetIPAddress {
	public static String getHostIp(){  
	    try{  
	        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();  //��ȡ������������ӿڣ�
	        while (allNetInterfaces.hasMoreElements()){  					//����ж���Ϊtrue
	            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();  //����ÿһ���ӿڣ�
	            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();  //��ȡ����ip��
	            while (addresses.hasMoreElements()){  
	                InetAddress ip = (InetAddress) addresses.nextElement();  //����ж����ַ�ͱ�����һ����
	                if (ip != null   
	                        && ip instanceof Inet4Address  //�Ƿ�ΪipV4��ַ��
	                        && !ip.isLoopbackAddress() //loopback��ַ��������ַ��IPv4��loopback��Χ��127.0.0.0 ~ 127.255.255.255  
	                        && ip.getHostAddress().indexOf(":")==-1){  
	                    System.out.println("������IP = " + ip.getHostAddress());  
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
