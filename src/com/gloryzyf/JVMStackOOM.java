package com.gloryzyf;
/**最好别尝试 windows7下直接卡死 只能强制重启了
 * VM Args:-Xss2M
 * @author YU
 *
 */
public class JVMStackOOM {
	
	private void doNotStop(){
		while(true){}
	}
	
	public void stackLeakByThread(){
		int i=0;
		while(true){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					doNotStop();
				}
			},i+"").start();;
			i++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JVMStackOOM oom=new JVMStackOOM();
		//oom.stackLeakByThread();
	}
}
