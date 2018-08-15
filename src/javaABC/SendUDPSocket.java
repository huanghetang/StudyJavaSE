package javaABC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendUDPSocket {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//网络IP
		InetAddress ia = InetAddress.getByName("ZMPC");
//		InetAddress ia = InetAddress.getByName("192.168.30.70");
//		InetAddress ia = InetAddress.getByName("192.168.198.1");
		//创建UDPSocket对象,DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while((str=br.readLine())!=null){
			if("886".equals(str)){
				break;
			}
			//创建数据包
			DatagramPacket dp = new DatagramPacket(str.getBytes(),str.getBytes().length,ia,10086);
			//发送数据包
			ds.send(dp);
		}
		//关闭UDPsocket资源
		ds.close();
		
	}

	private static void testUDP() throws UnknownHostException, SocketException, IOException {
		//创建UDPSocket对象,DatagramSocket
//		InetAddress ia = InetAddress.getByName("ZMPC");
		InetAddress ia = InetAddress.getByName("192.168.30.70");
//		InetAddress ia = InetAddress.getByName("192.168.198.1");
		//创建数据包
		DatagramSocket ds = new DatagramSocket();
		byte[] bys = "hello,UDP我来了!".getBytes();
		int len = bys.length;
		DatagramPacket dp = new DatagramPacket(bys,len,ia,10086);
		//发送数据包
		ds.send(dp);
		//关闭UDPsocket;
		ds.close();
	}

}
