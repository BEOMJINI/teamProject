package com.basic.projectbook.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String ctx = request.getContextPath();

		Mapping mapping = new Mapping();
		String controllerUri = uri.substring(ctx.length());
		Controller controllerSelect = mapping.getController(controllerUri);

		String controllerAction = null;
		controllerAction = controllerSelect.service(request, response);

		if (controllerAction != null) {
			if (controllerAction.indexOf(".do") != -1) {
				response.sendRedirect(controllerAction);
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(ViewPage.makeView(controllerAction));
				dis.forward(request, response);
			}
		}
	}
}
