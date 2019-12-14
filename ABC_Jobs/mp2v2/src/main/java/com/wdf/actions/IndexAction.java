package com.wdf.actions;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wdf.dao.NewsFeedDao;
import com.wdf.entity.NFThread;

public class IndexAction extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9054630364516027560L;
		List<NFThread> newsFeed = null;
		NewsFeedDao NF = new NewsFeedDao();
		Boolean dataset = false;


    public String execute() {
    	try {
			newsFeed = NF.getAllThread();
			if(newsFeed != null) {
				dataset = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(dataset);
    	System.out.println(newsFeed.toString());

        return "SUCCESS";
    }


}
