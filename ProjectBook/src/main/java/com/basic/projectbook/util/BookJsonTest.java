package com.basic.projectbook.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
		Random rd=new Random();
		String[]genreList= {"공포","추리","판타지","로맨스","과학","자기계발"};
		String[]countryList= {"한국","일본","중국","미국","프랑스","독일"};		
	    // loop array
		try {
			JSONParser jp = new JSONParser();
			JSONObject jsonObject = (JSONObject)jp.parse(jsonString);
			System.out.println(jsonObject);

		
           JSONArray items = (JSONArray)jsonObject.get("items");
           System.out.println(items);
 
  
        	    for (Object object : items) {
        	    	String genre=genreList[rd.nextInt(6)];
        	    	String country=countryList[rd.nextInt(6)];

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
        	        vo.setGenre(genre);
        	        vo.setCountry(country);
        	        
        	        BookDAO.getInstance().insertBook(vo);
        	    }
        	

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
