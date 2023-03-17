package com.basic.projectbook.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.vo.BookVO;
import com.google.gson.JsonObject;



public class BookJsonTest {

	public static List<BookVO>dataParse(String jsonString) {
		
		System.out.println("test:" + jsonString );
		List<BookVO> list = new ArrayList<>();
		
		
	    // loop array
		try {
			JSONParser jp = new JSONParser();
			JSONObject jsonObject = (JSONObject)jp.parse(jsonString);
			System.out.println(jsonObject);

		
           JSONArray items = (JSONArray)jsonObject.get("items");
           System.out.println(items);
 
  
        	    for (Object object : items) {

        	        JSONObject book = (JSONObject)jp.parse(object.toString());
        	        
        	        System.out.println(book.get("image"));
        	       //System.out.println( (String) jsonObject.get("image"));
        	       // String name = (String) jsonObject.get("author");
        	        //System.out.println("author: " + name  );
        	        BookVO vo = new BookVO();
        	        
        	        vo.setTitle((String) book.get("title"));
        	        vo.setImage((String) book.get("image"));
        	        vo.setAuthor((String) book.get("author"));
        	        vo.setDiscount((String) book.get("discount"));
        	        vo.setPublisher((String) book.get("publisher"));
        	        vo.setPubdate((String) book.get("pubdate"));
        	        vo.setIsbn((String) book.get("isbn"));
        	        vo.setDescription((String) book.get("description"));
        	        vo.setGenre("기술");
        	        vo.setCountry("국내");
        	        
        	        BookDAO.getInstance().insertBook(vo);
        	    }
        	

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
