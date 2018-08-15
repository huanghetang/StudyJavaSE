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
	 * 请编写程序，完成键盘录入学生信息，并计算总分将学生信息与总分一同写入文本文件
	 * 
	 * 需求：键盘录入3个学生信息(姓名,语文成绩,数学成绩)
	 * 
	 * 求出每个学生的总分
	 * 
	 * ,并且将学生的信息写入Student.txt文件中
	 * 
	 * 要求文件中的效果下所示
	 * 
	 * 
	 * 
	 * 姓名 语文成绩 数学成绩 总分
	 * 
	 * 李四 99 88 177
	 * 
	 * 张三 20 90 110
	 * 
	 * 王五 100 100 200
	 * @throws IOException 
	 */
	
	static void test1() throws IOException{
		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入3个");
		int count=1;
		ArrayList<Student> list = new ArrayList<Student>();
		while(count < 4){
			System.out.println("请输入第"+count+"个学生姓名:");
			String name = scanner.nextLine();
			System.out.println("请输入第"+count+"个学生语文成绩:");
			String chineseScore = scanner.nextLine();
			Integer cs = Integer.parseInt(chineseScore);
			System.out.println("请输入第"+count+"个学生数学成绩:");
			String mathScore = scanner.nextLine();
			Integer ms = Integer.parseInt(mathScore);
			Integer countScore = cs+ms;
			Test4_8.Student s = new Test4_8().new Student(name,cs,ms,countScore);
			list.add(s);
			count++;
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("Student.txt"));
		bw.write("姓名 语文成绩 数学成绩 总分");
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

