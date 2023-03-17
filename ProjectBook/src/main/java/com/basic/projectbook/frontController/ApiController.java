package com.basic.projectbook.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		return "SearchView";
	}

}
