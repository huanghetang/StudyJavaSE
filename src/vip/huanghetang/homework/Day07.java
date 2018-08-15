package vip.huanghetang.homework;

import java.util.Comparator;

public class Day07 {
	public static void main(String[] args) {
		Day07 day07 = new Day07();
//		Day07.Teacher t1 = new Day07().new Teacher("t001", "薛之谦", "男", 26, "Java");
//		Day07.Teacher t2 = day07.new Teacher("t002", "张碧晨", "女", 24, "IOS");
//		Day07.Teacher t3 = day07.new Teacher("t003", "张杰", "男", 28, "Java");
//		System.out.println(t1);
//		System.out.println(t2);
//		System.out.println(t3);
//		Course c1 = day07.new Course("s001","Java","2007-02-08","Java学科，包含JavaSE和JavaEE");
//		Course c2 = day07.new Course("s002","IOS","2007-02-09","IOS系统开发");
//		System.out.println(c1);
//		System.out.println(c2);
		Book b1 = day07.new Book("0100", 99.0, "java");
		Book b2 = day07.new Book("0111", 11.0, "ios");
//		if(b1.compare(b1, b2)==1){
//			System.out.println("最贵的书是"+b1);
//		}else{
//			System.out.println("最贵的书是"+b2);
//		}
		if(b1.compareTo(b2)==1){
			System.out.println("最贵的书是"+b1);
		}else{
			System.out.println("最贵的书是"+b2);
		}
		
	}
	
//	教师编号	姓名	性别	年龄	科目
//	t001			薛之谦	男		26		Java
//	t002			张碧晨	女		24		IOS
//	t003			张杰	男		28		Java

	class Teacher{
		private String teacherId;
		private String name;
		private String sex;
		private int age;
		private String subject;
		
		public Teacher(){
		}
		public Teacher(String teacherId,String name,String sex,int age,String subject){
			this.teacherId = teacherId;
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.subject = subject;
		}
		public void setTeacherId(String teacherId){
			this.teacherId = teacherId;
		}
		public String getTeacherId(){
			return teacherId;
		}
		public void setName(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		public void setSex(String sex){
			this.sex =sex;
		}
		public String getSex(){
			return sex;
		}
		public void setAge(int age){
			this.age = age;
		}
		public int getAge(){
			return age;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		@Override
		public String toString() {
			return "Teacher [teacherId=" + teacherId + ", name=" + name + ", sex=" + sex + ", age=" + age + ", subject="
					+ subject + "]";
		}
		
		
	}
	
//	课程编号	名称	创建时间	课程描述
//	s001			Java		2007-02-08	Java学科，包含JavaSE和JavaEE
//	s002			IOS		2007-02-09	IOS系统开发

	class Course{
		private String cid;
		private String cname;
		private String builddate;
		private String described;
		public String getCid() {
			return cid;
		}
		public void setCid(String cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getBuilddate() {
			return builddate;
		}
		public void setBuilddate(String builddate) {
			this.builddate = builddate;
		}
		public String getDescribed() {
			return described;
		}
		public void setDescribed(String described) {
			this.described = described;
		}
		public Course(){}
		public Course(String cid, String cname, String builddate, String described) {
			super();
			this.cid = cid;
			this.cname = cname;
			this.builddate = builddate;
			this.described = described;
		}
		@Override
		public String toString(){
			return "Course [cid="+cid+",cname="+cname+",builddate="+builddate+",described"
					+described+"]";
		}
	}
	
	class Book implements Comparator<Book>,Comparable<Book>{
		private String id;
		private double price;
		private String bookname;
		

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getBookname() {
			return bookname;
		}

		public void setBookname(String bookname) {
			this.bookname = bookname;
		}

		public Book(String id, double price, String bookname) {
			super();
			this.id = id;
			this.price = price;
			this.bookname = bookname;
		}
		

		@Override
		public String toString() {
			return "Book [id=" + id + ", price=" + price + ", bookname=" + bookname + "]";
		}

		@Override
		public int compare(Book o1, Book o2) {
			// TODO Auto-generated method stub
			if(o1.getPrice()>=o2.getPrice())
				return 1;
				else
					return -1;
		}

		@Override
		public int compareTo(Book o) {
			// TODO Auto-generated method stub
			if (this.getPrice()>=o.getPrice())
				return 1;
			else
				return -1;
			
//			return 0;
		}
		
		
	}
}
