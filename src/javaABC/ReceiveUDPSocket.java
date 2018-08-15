package javaABC;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveUDPSocket {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//创建UDP套接字对象
		DatagramSocket ds = new DatagramSocket(10086);
		while(true){
			//创建数据包
			byte[] bys = new byte[1024];
			int len = bys.length;
			DatagramPacket dp  = new DatagramPacket(bys,len);
			//接受数据
			ds.receive(dp);
			//解析数据
			InetAddress ia = dp.getAddress();//获取主机地址
			byte[] data = dp.getData();
			int dataLength = dp.getLength();
			String content = new String(data,0,dataLength);
			System.out.println("接收到"+ia.getHostName()+"发送的数据:"+content);
			
			new DatagramPacket("我收到 了".getBytes(),"我收到 了".getBytes().length,ia,10086);
		}
		
		//关闭UDP套接字
//		ds.close();
		
		
	}

	private static void testReceive() throws SocketException, IOException {
		//创建UDP套接字对象
		DatagramSocket ds = new DatagramSocket(10086);
		while(true){
			//创建数据包
			byte[] bys = new byte[1024];
			int len = bys.length;
			DatagramPacket dp  = new DatagramPacket(bys,len);
			//接受数据
			ds.receive(dp);
			//解析数据
			InetAddress ia = dp.getAddress();//获取主机地址
			byte[] data = dp.getData();
			int dataLength = dp.getLength();
			String content = new String(data,0,dataLength);
			System.out.println("接收到"+ia.getHostName()+"发送的数据:"+content);
		}

		//关闭UDP套接字
//		ds.close();
	}

}
