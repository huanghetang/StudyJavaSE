package vip.huanghetang.jybhomework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadPicture {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//�½�һ���׽���
		Socket socket = new Socket("127.0.0.1",10010);
		
		//���ӵ�������׽���
//		socket.connect(endpoint);
		//��ȡͨ�������
		OutputStream os = socket.getOutputStream();
		String path = "F:\\BaiduNetdiskDownload\\Java������Ƶ-����ǳ����������Ƶ\\4.png";
		File file = new File(path);
		FileInputStream fs = new FileInputStream(file);
		byte[] bys = new byte[1024];
		int length = -1;
		while((length=fs.read(bys))!=-1){
			os.write(bys, 0, length);
			os.flush();
		}
		socket.shutdownOutput();
		System.out.println("upload over");
	}

}
