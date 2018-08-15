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
	 * ��Ŀ��Ŀ¼���Ѵ����ļ�player.txt���ļ��д����Ա����� �洢��ʽ����(ԭʼ��Ա����Ӳ��ó���¼�룬���ֶ����ļ������ļ���¼������)��
	 * ��Ա,��ӣ��м��ã��ָ������磺 ������,��ʿ�� ����,������ ����,��ʿ�� ʯ����,���˶� �Ʊ�,���˶� 2. ��������ʱ����ʾ�û�������Ա��
	 * ������Ա���ҵ�����Ӧ����� 2.1 ����¼����Ա�� 2.2 ��player.txt�л�ȡ��Ա����������ӣ���֤����¼�����Ա�Ƿ����
	 * �ǣ�����̨����Ա�����������Ϣ��ӡ �񣺿���̨��ʾ�������ڸ���Ա������������ ���� ����ʾ¼����Ա���� ������Ӧ��� ¼�� ���� չʾ�� ����
	 * ���� ��ʿ�� ����ɹ��� ����Ҳ��� ������Ӧ����ʾ (30��)
	 * @throws IOException 
	 */
	
	
	static void findPlayer() throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѡ������:");
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
		boolean flag = false;//���ڶ�Ա��ʶ
		for (String s : list) {
			if(s.startsWith(playerName)){
				String name = s.substring(0, s.indexOf(","));
				String group = s.substring(s.indexOf(",")+1);
				System.out.println(name+"����"+group);
				flag = true;
				break;
			}
		}
		if(!flag){
			System.out.println("�����ڸ���Ա");
		}
		
	}
}
