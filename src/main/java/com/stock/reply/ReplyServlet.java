package com.stock.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

 
@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 서블릿이지만 출력은 board서블릿에서 출력을 하기때문에 따로 작성하지 않는다.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
   		//response.setContentType("text/html; charset=UTF-8");
   		
   		String pageGubun = request.getParameter("pageGubun");
   		ReplyDAO rdao = new ReplyDAO();
   		System.out.println("-" + pageGubun + "-");
   		
   		if (pageGubun == null) {
   			response.sendRedirect("/500.html");
   			

//		 ----------------------------------------------------------- 댓글입력  	
   		//pageGubun=RI001&bseq=12&reply=댓글댓글
   		} else if (pageGubun.equals("RI001")) {
		
			int bseq = 0;
			// 페이지 구분자와 댓글의 구분자를 파라미터로 받음
			String bseqStr = request.getParameter("bseq");
			String reply = request.getParameter("reply");

			if(bseqStr != null && !bseqStr.equals(""))  {
				bseq = Integer.parseInt(bseqStr);
				
				ReplyVO rvo = new ReplyVO();
				rvo.setReplycontents(reply);
				rvo.setUseq(11);
				rvo.setBseq(bseq);
				
				
				
				rvo.setReply(reply);
				rvo.setRegid("guest");
				rvo.setBseq(bseq);
				
				int res = rdao.insertReply(rvo);
				
				
//				정상적으로 댓글이 입력된 경우 --> 그자리에 머물러있기
				response.setContentType("application/json; charset=UTF-8");  //★★★★★★★★★★★★★★★★★★★★★★★★
				PrintWriter out = response.getWriter();
				if(res > 0) {
					List<MyreplyVO> rlist = rdao.myreplySelect(bseq);
	   				
					HashMap<String, Object> responseMap = new HashMap<String, Object>();
	   				responseMap.put("status", "200");
	   				responseMap.put("message", rlist);
	   				ObjectMapper mapper = new ObjectMapper();
	   				String jsonString = mapper.writeValueAsString(responseMap);
	   				out.write(jsonString);	
	   			} else {
	   				
	   				HashMap<String, Object> responseMap = new HashMap<String, Object>();
	   				responseMap.put("status", "500");
	   				responseMap.put("message", "error");
	   				ObjectMapper mapper = new ObjectMapper();
	   				String jsonString = mapper.writeValueAsString(responseMap);
	   				out.write(jsonString);	
	   			}
				
				
//				정상적으로 댓글이 입력된 경우 --> 그자리에 머물러있기
//				if(res > 0) {
//	   				response.sendRedirect("/myboard?bseq="+bseq+"&pageGubun=T001");
//	   			} else {
//	   				response.sendRedirect("/sb/500.html");
//	   			}
//			} else {
//				response.sendRedirect("/sb/500.html");
			}
		
//		 ----------------------------------------------------------- 댓글삭제
   		} else if (pageGubun.equals("RD001")) {
   			
   			int bseq = 0;
   			int rseq = 0;
   			String bseqStr = request.getParameter("bseq");
			String rseqStr = request.getParameter("rseq");
			if(  (bseqStr != null && !bseqStr.equals("")) && (rseqStr != null && !rseqStr.equals("")) )  {
				bseq = Integer.parseInt(bseqStr);
				rseq = Integer.parseInt(rseqStr);
				
				int res = rdao.deleteReply(rseq);
				
	   			//정상적으로 댓글이 삭제된 경우 --> 그자리에 머물러있기
				response.setContentType("application/json; charset=UTF-8");  //★★★★★★★★★★★★★★★★★★★★★★★★
				PrintWriter out = response.getWriter();
				if(res > 0) {
					// 상세페이지로( MyboardServlet.java : else if (pageGubun.equals("T001")) ) 가는 sendRedirect
					List<MyreplyVO> rlist = rdao.myreplySelect(bseq);
					
	   				HashMap<String, Object> responseMap = new HashMap<String, Object>();
	   				responseMap.put("status", "200");
	   				responseMap.put("message", rlist);
	   				ObjectMapper mapper = new ObjectMapper();
	   				String jsonString = mapper.writeValueAsString(responseMap);
	   				out.write(jsonString);	
	   			} else {
	   				
	   				HashMap<String, Object> responseMap = new HashMap<String, Object>();
	   				responseMap.put("status", "500");
	   				responseMap.put("message", "error");
	   				ObjectMapper mapper = new ObjectMapper();
	   				String jsonString = mapper.writeValueAsString(responseMap);
	   				out.write(jsonString);	
	   			}
				
//				if(res > 0) {
//	   				response.sendRedirect("/myboard?bseq="+bseq+"&pageGubun=T001");
//	   			} else {
//	   				response.sendRedirect("/sb/500.html");
//	   			}
//			}else {
//				response.sendRedirect("/sb/500.html");
			}
   		}
		
	}

}
