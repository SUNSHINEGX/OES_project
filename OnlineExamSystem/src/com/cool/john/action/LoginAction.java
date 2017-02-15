package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.cool.john.bean.Admin;
import com.cool.john.bean.Student;
import com.cool.john.bean.Teacher;
import com.cool.john.bean.TestPaperList;
import com.cool.john.service.AdminService;
import com.cool.john.service.StudentService;
import com.cool.john.service.TeacherService;
import com.cool.john.service.TestPaperListService;
import com.cool.john.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private String manageName;
	private String password;
	private String identify;
	private Student stu;
	private Admin adm;
	private StudentService stuService;
	private AdminService admService;
	private TestPaperListService tpService;
	private Teacher teacher;
	private TeacherService teacherService;
	
	
	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	
	
	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	


	public Admin getAdm() {
		return adm;
	}

	public void setAdm(Admin adm) {
		this.adm = adm;
	}

	public StudentService getStuService() {
		return stuService;
	}

	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
	}
	

	

	public AdminService getAdmService() {
		return admService;
	}

	public void setAdmService(AdminService admService) {
		this.admService = admService;
	}

	public TestPaperListService getTpService() {
		return tpService;
	}

	public void setTpService(TestPaperListService tpService) {
		this.tpService = tpService;
	}

	@Override
	public void validate() {
		if(StringUtil.isEmpty(this.getManageName())||StringUtil.isEmpty(this.getPassword())){
			this.addFieldError("manageName", "管理员名称或者密码不能为空");
			//System.out.println("111");
		}
	}

	@Override
	public String execute() throws Exception {
		System.out.println("用户名或者密码没有空");
		System.out.println(this.getManageName());
		System.out.println(this.getIdentify());
		String flag = this.getIdentify();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession hs = req.getSession();
		ActionContext ac = ActionContext.getContext();
		
		if(flag.equals("1")){
			//System.out.println("超级管理员");
			adm = new Admin(manageName,password);
			List list = this.getAdmService().find(adm);
			System.out.println(list);
			if(list.size()>0){
				Admin adm1 = (Admin)list.get(0);
				String name = adm1.getAdminName();
				ac.put("manage_name", name);
				return "success_superManager";
			}else{
				this.addFieldError("manageName", "管理员名称或者密码不正确,请正视您的身份");
				return "input";
			}				
		}else if(flag.equals("2")){
			//System.out.println("教师");
			teacher = new Teacher();
			teacher.setPassword(password);
			teacher.setTeaNum(manageName);
			System.out.println(teacher);
			System.out.println(teacherService);
			List<Teacher> list = this.getTeacherService().find(teacher);
			System.out.println(list);
			if(list.size()>0){
				Teacher tea1 = list.get(0);
				String name = tea1.getTeaName();
				String num = tea1.getTeaNum();
				//ac.put("manage_name",num);
			
			hs.setAttribute("manage_name", name);
				hs.setAttribute("manage_num", num);
											
				return "success_teacher";
			}else{
				this.addFieldError("manageName", "管理员名称或者密码不正确,请正视您的身份,不要充大头鬼好吗");
				return "input";
			}			
		}else{
			stu=new Student(manageName,password);			
			//System.out.println("学生");
			List list = this.getStuService().find(stu);									
			System.out.println(list);
			if(list.size()>0){
				Student stu1 = (Student)list.get(0);
				String name = stu1.getStuName();
				String classNum = stu1.getClassNum();
				String stuNum = stu1.getStuNum();
				hs.setAttribute("stuNum", stuNum);				
				ac.put("manage_name", name);
				ac.put("classNum", classNum);
				ac.put("stuNum", stuNum);
				System.out.println(name);
				return "success_student";
			}else{
				this.addFieldError("manageName", "管理员名称或者密码不正确,请正视您的身份,不要充大头鬼好吗");
				return "input";
			}
			
		}				
	}
		
	
	public static void main(String[] args) {
		
	}

}
