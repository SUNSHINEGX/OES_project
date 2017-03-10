package com.online.interceptor;

import com.online.action.RegistAction;
import com.online.domain.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;

import org.hibernate.Transaction;

/**
 * @author  yeeku.H.lee kongyeeku@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */
public class TransInterceptor extends AbstractInterceptor
{
	private String name;
	public void setName(String name)
	{
		this.name = name;
	}

    public String intercept(ActionInvocation invocation) throws Exception
	{
	//RegistAction action = (RegistAction)invocation.getAction();
	String  methodName=invocation.getInvocationContext().getName();
	String result="";

	if (methodName.startsWith("add") || methodName.startsWith("update") 
			|| methodName.startsWith("delete"))
	  {
		Transaction t=HibernateSessionFactory.getSession().beginTransaction();
		System.out.println("begin transaction");
		t.begin();
		result = invocation.invoke();
		t.commit();
		System.out.println("end transaction");
	  }
	return result;
    }
}
