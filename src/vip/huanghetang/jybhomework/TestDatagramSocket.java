package vip.huanghetang.jybhomework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPͨ��
 * @author zhoumo
 *
 */
public class TestDatagramSocket {

	public static void main(String[] args) throws IOException {
//		InetAddress address = InetAddress.getByName("192.168.30.70");
		InetAddress address = InetAddress.getByName("127.0.0.1");
		DatagramSocket ds = new DatagramSocket(10086);
		ReviceDatagramSocket dsr = new ReviceDatagramSocket(ds);
		//����һ���߳̽�����Ϣ
		new Thread(dsr).start();
		
		//����һ���̷߳�����Ϣ
		SentDatagramSocket dss = new SentDatagramSocket(ds,address);
		new Thread(dss).start();
	}

}

class ReviceDatagramSocket implements Runnable{
	private DatagramSocket ds;
	ReviceDatagramSocket(DatagramSocket ds){
		this.ds = ds;
	}
	@Override
	public void run() {
		while(true){
			//UDP������Ϣ����
			//�������ݰ�
			DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
			try {
				ds.receive(dp);//�������ݰ�,��������
				InetAddress address = dp.getAddress();//��ȡIP����
				int port = dp.getPort();//��ȡ�˿ں�
				byte[] content = dp.getData();//��ȡ����
				System.out.println("data "+new String(content,0,dp.getLength())+" is from prot:"+port+" address:"+address.getHostAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

class SentDatagramSocket implements Runnable{
	private DatagramSocket ds ;
	private InetAddress address;
	SentDatagramSocket(DatagramSocket ds,InetAddress address){
		this.ds = ds;
		this.address = address;
	}
	@Override
	public void run() {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			while((str=bw.readLine())!=null){
//				if("886".equals(str)){
//				break;
//				}
			byte[] bys = str.getBytes();
			//�½�UTP���ݱ�
			DatagramPacket dp = new DatagramPacket(bys,bys.length,address,10086);
			//�������ݱ���
			ds.send(dp);
			}
//			ds.close();//java.net.SocketException: socket closed
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}