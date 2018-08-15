package javaABC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test4_8$2 {
	
	public static void main(String[] args) throws IOException {
		findPlayer();
	}

	/**
	 * 项目根目录下已存在文件player.txt，文件中存放球员和球队 存储格式如下(原始球员和球队不用程序录入，可手动建文件并在文件中录入数据)：
	 * 球员,球队（中间用，分隔），如： 杜兰特,勇士队 威少,雷霆队 库里,勇士队 石破天,湖人队 科比,湖人队 2. 程序启动时：提示用户输入球员名
	 * 根据球员名找到所对应的球队 2.1 键盘录入球员名 2.2 在player.txt中获取球员名和所属球队，验证键盘录入的球员是否存在
	 * 是：控制台将球员的所属球队信息打印 否：控制台提示：不存在该球员，并结束程序 例如 ：提示录入球员姓名 检索对应球队 录入 库里 展示出 库里
	 * 所属 勇士队 即完成功能 如果找不到 给出相应的提示 (30分)
	 * @throws IOException 
	 */
	
	
	static void findPlayer() throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入选手姓名:");
		String playerName = sc.nextLine();
		BufferedReader br = new BufferedReader(new FileReader("player.txt"));
		//hashMap
		ArrayList<String> list = new ArrayList<String>();
		String content = null;
		while((content = br.readLine())!=null){
//			System.out.println(content);
			list.add(content);
		}
		br.close();
		boolean flag = false;//存在队员标识
		for (String s : list) {
			if(s.startsWith(playerName)){
				String name = s.substring(0, s.indexOf(","));
				String group = s.substring(s.indexOf(",")+1);
				System.out.println(name+"所属"+group);
				flag = true;
				break;
			}
		}
		if(!flag){
			System.out.println("不存在该球员");
		}
		
	}
}
