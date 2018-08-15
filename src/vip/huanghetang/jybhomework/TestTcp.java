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
 * 使用TCP协议接受客户端发送的图片
 * @author zhoumo
 *
 */
public class TestTcp {
	public static void main(String[] args) {
		//下载图片服务
		SocketService service = new SocketService();
		
		new Thread(service).start();
		
		
	}
	
	
	

}
class SocketService implements Runnable{
	
	@Override
	public void run() {
		try {
			//新建一个服务器套接字对象
		ServerSocket ss = 	new ServerSocket(10010);
		while(true){
			Socket socket = ss.accept();//开始监听,阻塞方法
			//得到socket 套接字 输入流管道对象
			InputStream is = socket.getInputStream();
			String fileName = UUID.randomUUID().toString().replaceAll("-", "");
			File file = new File("E:\\hm\\picture\\"+fileName+".jpg");//保存到这个路径下
			//新建一个输出流对象
			FileOutputStream fos = new FileOutputStream(file);//写到文件
			byte[] bys = new byte[1024];
			int len = -1;
			while((len=is.read(bys))!=-1){
				fos.write(bys,0,len);
				fos.flush();
			}
			System.out.println("接受到一个文件"+"E:\\hm\\picture"+fileName+".jpg");
			fos.close();
			is.close();
			socket.close();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
