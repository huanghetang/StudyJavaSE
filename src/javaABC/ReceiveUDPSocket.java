package javaABC;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveUDPSocket {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//����UDP�׽��ֶ���
		DatagramSocket ds = new DatagramSocket(10086);
		while(true){
			//�������ݰ�
			byte[] bys = new byte[1024];
			int len = bys.length;
			DatagramPacket dp  = new DatagramPacket(bys,len);
			//��������
			ds.receive(dp);
			//��������
			InetAddress ia = dp.getAddress();//��ȡ������ַ
			byte[] data = dp.getData();
			int dataLength = dp.getLength();
			String content = new String(data,0,dataLength);
			System.out.println("���յ�"+ia.getHostName()+"���͵�����:"+content);
			
			new DatagramPacket("���յ� ��".getBytes(),"���յ� ��".getBytes().length,ia,10086);
		}
		
		//�ر�UDP�׽���
//		ds.close();
		
		
	}

	private static void testReceive() throws SocketException, IOException {
		//����UDP�׽��ֶ���
		DatagramSocket ds = new DatagramSocket(10086);
		while(true){
			//�������ݰ�
			byte[] bys = new byte[1024];
			int len = bys.length;
			DatagramPacket dp  = new DatagramPacket(bys,len);
			//��������
			ds.receive(dp);
			//��������
			InetAddress ia = dp.getAddress();//��ȡ������ַ
			byte[] data = dp.getData();
			int dataLength = dp.getLength();
			String content = new String(data,0,dataLength);
			System.out.println("���յ�"+ia.getHostName()+"���͵�����:"+content);
		}

		//�ر�UDP�׽���
//		ds.close();
	}

}
