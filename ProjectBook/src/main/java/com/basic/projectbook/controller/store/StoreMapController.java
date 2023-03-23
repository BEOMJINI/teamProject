package com.basic.projectbook.controller.store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.StoreDAO;
import com.basic.projectbook.dao.StoreMapDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.StoreMapVO;
import com.basic.projectbook.vo.StoreVO;

public class StoreMapController implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int storeid=Integer.parseInt(request.getParameter("storeid"));
		StoreMapVO vo=StoreMapDAO.getInstance().getStoreMapInfo(storeid);
		request.setAttribute("vo", vo);
		
		return "store/storeMap";
	}

}
