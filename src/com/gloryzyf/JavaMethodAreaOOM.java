package com.gloryzyf;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			Enhancer enhancer=new Enhancer();
			enhancer.setSuperclass(OOM.class);
			enhancer.setUseCache(false);//
			enhancer.setCallback(new MethodInterceptor(){
				@Override
				public Object intercept(Object obj, Method method,
						Object[] args, MethodProxy proxy) throws Throwable {
					// TODO Auto-generated method stub
					return proxy.invoke(obj,args);
				}
			});
			enhancer.create();
		}
	}
	
	static class OOM{
	}

}
