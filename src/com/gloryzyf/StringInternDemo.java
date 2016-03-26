package com.gloryzyf;
/**
 * jdk7在Strign.intern()方法上策略的改变和jdk6.0不一样了
 * 在jdk6.0中是调用intern方法时去常量池中找，如果没有就把字符串拷贝到运行时常量池中
 * 在jdk7.0中是如果没有是不会进行复制了，只是在常量池中记录首次出现实例的引用
 * @author YU
 *
 */
public class StringInternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="java";
		
		String s1=new StringBuilder("计算机").toString();
		System.out.println(s1.intern()==s1);
		//false  在编译的时候“计算机”已经添加到了字节码中的常量池中了 所以s1是堆中的字符串地址 s1.intern返回的字符串常量池中的地址
		
		String s2=new StringBuilder("计算机").append("软件").toString();
		System.out.println(s2.intern()==s2);
		//true  在编译的时候“计算机”和“软件”已经添加到了字节码中的常量池中了 但是“计算机软件”还没有加到字符创常量池中，只有运行到appned后才会有
		//所以s2是堆中的字符串地址 s2.intern返回的也是s2的地址 
		String s3=new StringBuilder("jav").append("a").toString();
		System.out.println(s3.intern()==s3);
		//false 因为在jvm加载rt.jar或者ext.jar的时候一些类中已经存在了"java"字符串了，所以已经放到了运行时常量池中了
		String s4=new StringBuilder("jav").append("aa").toString();
		System.out.println(s4.intern()==s4);
		//true
	}

}
