package javaABC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test4_8 {
	
	public static void main(String[] args) throws IOException {
		test1();
	}
	
	
	
	
	/**
	 * ���д������ɼ���¼��ѧ����Ϣ���������ֽܷ�ѧ����Ϣ���ܷ�һͬд���ı��ļ�
	 * 
	 * ���󣺼���¼��3��ѧ����Ϣ(����,���ĳɼ�,��ѧ�ɼ�)
	 * 
	 * ���ÿ��ѧ�����ܷ�
	 * 
	 * ,���ҽ�ѧ������Ϣд��Student.txt�ļ���
	 * 
	 * Ҫ���ļ��е�Ч������ʾ
	 * 
	 * 
	 * 
	 * ���� ���ĳɼ� ��ѧ�ɼ� �ܷ�
	 * 
	 * ���� 99 88 177
	 * 
	 * ���� 20 90 110
	 * 
	 * ���� 100 100 200
	 * @throws IOException 
	 */
	
	static void test1() throws IOException{
		Scanner scanner = new Scanner(System.in);
//		System.out.println("������3��");
		int count=1;
		ArrayList<Student> list = new ArrayList<Student>();
		while(count < 4){
			System.out.println("�������"+count+"��ѧ������:");
			String name = scanner.nextLine();
			System.out.println("�������"+count+"��ѧ�����ĳɼ�:");
			String chineseScore = scanner.nextLine();
			Integer cs = Integer.parseInt(chineseScore);
			System.out.println("�������"+count+"��ѧ����ѧ�ɼ�:");
			String mathScore = scanner.nextLine();
			Integer ms = Integer.parseInt(mathScore);
			Integer countScore = cs+ms;
			Test4_8.Student s = new Test4_8().new Student(name,cs,ms,countScore);
			list.add(s);
			count++;
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("Student.txt"));
		bw.write("���� ���ĳɼ� ��ѧ�ɼ� �ܷ�");
		bw.newLine();
		bw.flush();
		for (Student s : list) {
			bw.write(s.getName()+" "+s.getChineseScore()+" "+s.getMathScore()+" "+s.getCountScore());
			bw.newLine();
			bw.flush();
		}
		bw.close();
		System.out.println("over");
		
		
		
	}
	class Student{
		private String name;
		private Integer chineseScore;
		private Integer mathScore;
		private Integer countScore;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getChineseScore() {
			return chineseScore;
		}
		public void setChineseScore(Integer chineseScore) {
			this.chineseScore = chineseScore;
		}
		public Integer getMathScore() {
			return mathScore;
		}
		public void setMathScore(Integer mathScore) {
			this.mathScore = mathScore;
		}
		public Integer getCountScore() {
			return countScore;
		}
		public void setCountScore(Integer countScore) {
			this.countScore = countScore;
		}
		public Student(String name, Integer chineseScore, Integer mathScore,Integer countScore) {
			super();
			this.name = name;
			this.chineseScore = chineseScore;
			this.mathScore = mathScore;
			this.countScore = countScore;
		}
		
	}

}

