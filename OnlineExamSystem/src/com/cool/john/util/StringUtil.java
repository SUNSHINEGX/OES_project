package com.cool.john.util;

public class StringUtil {
	public static boolean isEmpty(String str){
		//要先判断str对象是否为空，才能对str字符串进行判断，否则会抛空指针，因为equals不能对对象进行判断
		if(str==null||str==""||str.equals("")||str.equals(null)){
			return true;
		}else{
			return false;
		}
	}
}
