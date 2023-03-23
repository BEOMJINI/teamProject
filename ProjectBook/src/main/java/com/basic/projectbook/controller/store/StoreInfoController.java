package com.basic.projectbook.controller.store;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.StoreDAO;
import com.basic.projectbook.dao.StoreMapDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.StoreMapVO;
import com.basic.projectbook.vo.StoreVO;

public class StoreInfoController implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<StoreMapVO>list=StoreMapDAO.getInstance().getAllMap();
		
		request.setAttribute("list", list);
		
		return "store/storeInfo";
	}

}
