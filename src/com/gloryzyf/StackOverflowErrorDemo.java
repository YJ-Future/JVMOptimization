package com.gloryzyf;
/**栈深度大造成栈内存溢出
 * -verbose:gc -Xss128k -XX:+PrintGCDetails
 * @author YU
 *
 */
public class StackOverflowErrorDemo {

	private int stackLength=1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOverflowErrorDemo oom=new StackOverflowErrorDemo();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("Stack length:"+oom.stackLength);
			throw e;
		}
	}
}
