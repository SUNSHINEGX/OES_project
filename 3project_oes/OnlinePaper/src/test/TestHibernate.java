package test;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.online.dao.OperatorDAO;
import com.online.dao.StudentinfoDAO;
import com.online.domain.*;


public class TestHibernate {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Operator opt=new Operator();
		opt.setOptId("A0031");
		opt.setPassword("111111");
		//opt.setOptName("kelvin");
		//opt.setIsAdmin(true);
		//opt.setIsExpired(true);

		Studentinfo std=new Studentinfo();
		//std.setStdId(1);
		std.setAge(13);
		std.setGrade("3");
		std.setName("tom");
		std.setSex(1);
		//std.setStudscores(studscores);
		std.setTeacher("teacZhang");
		//std.setStudscores(null);


		HashSet hs=new HashSet();
		hs.add(std);
		opt.setStudentinfos(hs);
		std.setOperator(opt);

		
		Transaction t=HibernateSessionFactory.getSession().beginTransaction();
		t.begin();
		OperatorDAO  optDAO=new OperatorDAO();
	    optDAO.save(opt);
		//StudentinfoDAO stdDAO=new StudentinfoDAO();
		//stdDAO.save(std);
	    t.commit();
	}
}