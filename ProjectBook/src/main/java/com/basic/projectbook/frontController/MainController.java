package com.basic.projectbook.frontController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.MemberVO;

public class MainController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MemberVO> list = MemberDAO.getInstance().getAllMember();
		System.out.println(list);
		request.setAttribute("list", list);
		
		MemberVO vo = MemberDAO.getInstance().getOneMember("1");
		request.setAttribute("test", vo);
			
		List<BookVO>latestThreeBookList=BookDAO.getInstance().getLatestThreeBook();
		for(int i=0;i<latestThreeBookList.size();i++) {
			if(latestThreeBookList.get(i).getDescription().length()>100) {
				String description=latestThreeBookList.get(i).getDescription().substring(0, 100)+"...";
				latestThreeBookList.get(i).setDescription(description);
				
			}
		}
		HttpSession session = request.getSession();
		String id=null;
		if(session.getAttribute("id")!=null) {
			id=(String)session.getAttribute("id");
		}
		
		
		System.out.println("현재 로그인 아이디:"+id);
		MemberVO memberInfo=null;
		String genre=null;
				if(id!=null&&id!="admin") {memberInfo=MemberDAO.getInstance().getOneMember(id);
				genre=memberInfo.getInterest();
				}
		
				
				System.out.println("회원가입장르:"+genre);
		List<BookVO>recommendList=new ArrayList<BookVO>();
		if(genre==null) {
			recommendList=latestThreeBookList;
		}
		else {
		if(genre.contains("/")) {
			String arr[]=genre.split("/");
			for(int i=0;i<arr.length;i++) {
				BookVO genreVO=BookDAO.getInstance().getOneBookGenre(arr[i]);
				recommendList.add(genreVO);
			}
		}
		else {
			recommendList=BookDAO.getInstance().getBookListGenre(genre);
		}
		}
		System.out.println("size:"+latestThreeBookList.size());
		request.setAttribute("threebook", latestThreeBookList);
		request.setAttribute("recommendList", recommendList);
		
		
		return "main";
		
		
		
	}

}
