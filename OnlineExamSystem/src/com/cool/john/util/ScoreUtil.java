package com.cool.john.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.UUID;

public class ScoreUtil {
	//生成文件的名字
		public String fileName(){
			UUID uuid = UUID.randomUUID();
			return uuid+".html";
		}
		
		//把考试信息保存到文件
		public void saveAsFileWriter(String content,String fileName) throws IOException {
	            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8");
	            out.write(content);
	            out.flush();
	            out.close();
	    }
}
