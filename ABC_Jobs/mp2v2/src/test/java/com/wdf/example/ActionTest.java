package com.wdf.example;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;
import com.wdf.actions.LinkAction;
import com.wdf.actions.LoginAction;
import com.wdf.actions.RegisterAction;
import com.wdf.actions.SearchAction;

public class ActionTest extends StrutsTestCase{
	
	public void testRegisterActionDuplicateEmail() throws Exception
	{
		// parameters are fname, lname, email, password, cpassword
		request.setParameter("fname", "Jiing Jiunn");
		request.setParameter("lname", "Tan");
		request.setParameter("email", "jiingjiunn@gmail.com");
		request.setParameter("password", "3mGU5*#s");
		request.setParameter("cpassword", "3mGU5*#s");
		
		ActionProxy proxy = getActionProxy("/register");
		
		RegisterAction registerAction = (RegisterAction) proxy.getAction();
		
		String result = proxy.execute();
		
		assertTrue("There should not be any problem.", registerAction.getFieldErrors().size() == 0 );
		assertEquals("Result returned from executing the action was not success but it should have been.","error",result);
	}
	
	public void testLinkAction() throws Exception
	{
		
		ActionProxy proxy = getActionProxy("/loginLink");
		
		LinkAction linkAction = (LinkAction) proxy.getAction();
		
		String result = proxy.execute();
		
		assertEquals("Result returned from executing the action was not login but it should have been.","login",result);
	}
	
	public void testSearchAction() throws Exception {
		request.setParameter("query", "mail");
		
		ActionProxy proxy = getActionProxy("/search");
		
		SearchAction searchAction = (SearchAction) proxy.getAction();
		
		String result = proxy.execute();
		
		assertEquals("Result returned from executing the action was not success but it should have been.","success",result);
		
	}
}
