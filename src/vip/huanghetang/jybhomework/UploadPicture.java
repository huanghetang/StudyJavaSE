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
		//新建一个套接字
		Socket socket = new Socket("127.0.0.1",10010);
		
		//连接到服务端套接字
//		socket.connect(endpoint);
		//获取通道输出流
		OutputStream os = socket.getOutputStream();
		String path = "F:\\BaiduNetdiskDownload\\Java基础视频-深入浅出精华版视频\\4.png";
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
