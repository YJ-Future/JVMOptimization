package com.gloryzyf;
/**
 * VM args:-XX:PermSize10M -XX:MaxPermSize10M
 * 没有发生永久代的内存溢出问题 证明在jdk7.0中运行时常量池不在永久代了
 */
import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}

}
