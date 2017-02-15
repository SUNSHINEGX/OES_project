package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Choice;
import com.cool.john.bean.Wenda;
import com.cool.john.service.WendaService;

public class WendaAction {
	private Wenda wenda;
	private WendaService wendaService;
	public Wenda getWenda() {
		return wenda;
	}
	public void setWenda(Wenda wenda) {
		this.wenda = wenda;
	}
	public WendaService getWendaService() {
		return wendaService;
	}
	public void setWendaService(WendaService wendaService) {
		this.wendaService = wendaService;
	}
	public void wenda(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag = request.getParameter("flag");
		List<Wenda> list1 = this.getWendaService().find(wenda);
		if(list1.size()>0){
			Wenda wen = new Wenda();
			wen = list1.get(0);
			wen.setLevel(wenda.getLevel());
			this.getWendaService().update(wen);
		}else{
			wenda.setSubject(flag);
			this.getWendaService().insert(wenda);
			System.out.println("≤Â»Îsuccess");
		}
		
	}
	
	
	public void chawen() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag =new String(request.getParameter("flag").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(flag);
		List<Wenda> list2 = this.getWendaService().prosuch(flag);
		System.out.println(list2.size());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(list2.toString());
	}
}
