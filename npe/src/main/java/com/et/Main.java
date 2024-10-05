package com.et;

import java.util.List;

/**
 * @ClassName Main
 * @Description TODO
 * @Author liuhaihua
 * @Date 2024/10/5 19:41
 * @Version 1.0
 */
public class Main {
	public static void main(String[] args) {
		//test1();
		//test4();
		String result =test6();
	}


	public static void test1(){
		throw null;
	}
	public static void test2(){
		Object obj = null;
		synchronized (obj){
			//.....
		}
	}
	public static void test3(){
		String str = "this is a test";
		boolean flag = str.equals("this is a test");
		System.out.println("===equals result====" + flag);

		str = null;
		flag = str.equals("this is a test");
		System.out.println("===equals result====" + flag);
	}
	public static void test4(){
		List list =null;
		int aaa=list.size();
	}
	public static void test5(){
		List<String> list =null;
		String aaa=list.get(0);
	}
	public static String test6(){
		return null;
	}
}
