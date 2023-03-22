package com.basic.projectbook.controller.applyrestock;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.ApplyRestockDAO;
import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.frontController.Controller;

import com.basic.projectbook.vo.ApplyRestockVO;

public class ApplyRestockController implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ApplyRestockVO> list = BookStockDAO.getInstance().getAllZeroStock();
		request.setAttribute("list", list);

		return "applyrestock/applyRestock";
	}

}
