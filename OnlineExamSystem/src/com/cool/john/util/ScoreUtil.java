package com.cool.john.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.UUID;

public class ScoreUtil {
	//�����ļ�������
		public String fileName(){
			UUID uuid = UUID.randomUUID();
			return uuid+".html";
		}
		
		//�ѿ�����Ϣ���浽�ļ�
		public void saveAsFileWriter(String content,String fileName) throws IOException {
	            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8");
	            out.write(content);
	            out.flush();
	            out.close();
	    }
}
