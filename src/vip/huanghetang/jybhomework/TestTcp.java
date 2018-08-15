package vip.huanghetang.jybhomework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * ʹ��TCPЭ����ܿͻ��˷��͵�ͼƬ
 * @author zhoumo
 *
 */
public class TestTcp {
	public static void main(String[] args) {
		//����ͼƬ����
		SocketService service = new SocketService();
		
		new Thread(service).start();
		
		
	}
	
	
	

}
class SocketService implements Runnable{
	
	@Override
	public void run() {
		try {
			//�½�һ���������׽��ֶ���
		ServerSocket ss = 	new ServerSocket(10010);
		while(true){
			Socket socket = ss.accept();//��ʼ����,��������
			//�õ�socket �׽��� �������ܵ�����
			InputStream is = socket.getInputStream();
			String fileName = UUID.randomUUID().toString().replaceAll("-", "");
			File file = new File("E:\\hm\\picture\\"+fileName+".jpg");//���浽���·����
			//�½�һ�����������
			FileOutputStream fos = new FileOutputStream(file);//д���ļ�
			byte[] bys = new byte[1024];
			int len = -1;
			while((len=is.read(bys))!=-1){
				fos.write(bys,0,len);
				fos.flush();
			}
			System.out.println("���ܵ�һ���ļ�"+"E:\\hm\\picture"+fileName+".jpg");
			fos.close();
			is.close();
			socket.close();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
