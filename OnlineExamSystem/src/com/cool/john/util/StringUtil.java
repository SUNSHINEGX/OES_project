package com.cool.john.util;

public class StringUtil {
	public static boolean isEmpty(String str){
		//Ҫ���ж�str�����Ƿ�Ϊ�գ����ܶ�str�ַ��������жϣ�������׿�ָ�룬��Ϊequals���ܶԶ�������ж�
		if(str==null||str==""||str.equals("")||str.equals(null)){
			return true;
		}else{
			return false;
		}
	}
}
