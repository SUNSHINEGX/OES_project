package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Choice;
import com.cool.john.bean.Tiankong;
import com.cool.john.service.TiankongService;

public class TiankongAction {
	private Tiankong tiankong;
	private TiankongService tiankongService;
	public Tiankong getTiankong() {
		return tiankong;
	}
	public void setTiankong(Tiankong tiankong) {
		this.tiankong = tiankong;
	}
	public TiankongService getTiankongService() {
		return tiankongService;
	}
	public void setTiankongService(TiankongService tiankongService) {
		this.tiankongService = tiankongService;
	}
	public void tiankong(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag = request.getParameter("flag");
		List<Tiankong> list1 = this.getTiankongService().find(tiankong);
		
		if(list1.size()>0){
			Tiankong tian = new Tiankong();
			tian=list1.get(0);
			tian.setAnswer(tiankong.getAnswer());
			tian.setLevel(tiankong.getLevel());
			
			
			this.getTiankongService().update(tian);
		}else{
			tiankong.setSubject(flag);
			this.getTiankongService().insert(tiankong);
		}
		System.out.println("success");
	}
	
	
	public void chatian() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag =new String(request.getParameter("flag").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(flag);
		List<Tiankong> list2 = this.getTiankongService().prosuch(flag);
		System.out.println(list2.size());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(list2.toString());
	}
}
