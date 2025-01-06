package com.stock.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.common.PagingUtil;
import com.stock.reply.ReplyDAO;
import com.stock.reply.ReplyVO;

@WebServlet("/detailpage")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 고유 식별자 추가
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
   		response.setContentType("text/html; charset=UTF-8");
   		
   		// 페이지 구분에 따라서 처리방법을 바꾸기 위해 파라미터 생성
   		String pageGubun = request.getParameter("pageGubun");
    	BoardDAO bdao = new BoardDAO();
    	
    	System.out.println("----------" + pageGubun + "----------");
    	
    	// pageGubun 값이 null이거나 빈 문자열일 경우 목록 보기 처리를 진행합니다.
   		// 기본적으로 pageGubun이 지정되지 않았을 때 실행되는 로직
   		if (pageGubun == null || pageGubun.equals("")) {
   			
   			//PagingUtil(String url, int currentPage, int totRecord, int blockCount, int blockPage)
   			int currentPage = 1;	//현재 페이지 초기값 설정 : 1(첫 페이지)
   			String currentPageStr = request.getParameter("currentPage");	// 요청에서 currentPage라는 이름의 값을 가져옵니다.
   			if(currentPageStr != null && !currentPageStr.equals(""))  {		//값이 null이 아니고 빈 문자열이 아닌 경우, 이를 정수로 변환하여 currentPage 변수에 저장
   				currentPage = Integer.parseInt(currentPageStr);
   			}
   			
   			// boardSelect() 메서드를 호출하여 모든 게시물의 리스트를 가져옵니다.
   			// 그 리스트의 크기를 계산하여 totRecord 변수에 저장
   			// 전체 게시물의 개수를 나타냅니다.
   			int totRecord = bdao.boardSelect().size();
   			System.out.println("게시물 목록 크기: " + totRecord);
//   		for (BoardVO board : totRecord) {
//              System.out.println("BSEQ: " + board.getBseq() + ", Title: " + board.getTitle() + ", Contents: " + board.getBoardcontents());
//          }
   			
   			int blockCount = 10; // 한 페이지에 보여줄 게시물 수
   			int blockPage = 5;  // 페이징 바에 표시할 페이지 링크 수
   			
   			// PagingUtil 클래스를 이용하여 페이징 처리를 위한 계산을 수행
   			///myboard: 기본 URL입니다.
   			// currentPage: 현재 페이지 번호.
   			// totRecord: 전체 게시물 수.
   			// blockCount: 한 페이지당 게시물 수.
   			// blockPage: 페이징 바에서 표시할 페이지 링크 수.
   			PagingUtil pg = new PagingUtil("/detailpage", currentPage, totRecord, blockCount, blockPage);
   			
   			// 현재 페이지의 게시물 목록 가져오기
   			// pg.getStartSeq()와 pg.getEndSeq()로 현재 페이지의 시작 및 끝 게시물 번호를 계산
   			// 반환된 리스트는 blist 변수에 저장되며, 현재 페이지에 표시할 게시물 목록을 나타냅니다.
   			ArrayList<BoardVO> blist = bdao.boardSelect( pg.getStartSeq(), pg.getEndSeq());
   			
   			  			
   			// pg.getPagingHtml()은 페이징 링크 HTML을 생성
   			// JSP에서 사용할 수 있도록 request 객체에 추가
   			request.setAttribute("MY_KEY_PAGING_HTML", pg.getPagingHtml().toString());
   			
   			//현재 페이지에 표시할 게시물 리스트를 request 객체에 추가
   			request.setAttribute("MY_KEY_BLIST", blist);
   			
   			
   			for(BoardVO bvo1: blist) {
   				System.out.println(bvo1);
   			}
   			
   			// JSP 페이지로 포워딩 : board_list.jsp로 foward
   			request.getRequestDispatcher("/detailpage.jsp").forward(request, response);
   			
   		// board_list.jsp로 구분자를 받아오면 출력
   		} else if (pageGubun.equals("T001")) {
   			int bseq = 1;
   			
   			System.out.println("----------" + pageGubun + "----------");
   			
   			String bseqStr = request.getParameter("bseq");
   			
   			if(bseqStr != null && !bseqStr.equals(""))  {
   				bseq = Integer.parseInt(bseqStr);
   				
   				// 게시불의 상세보기
   				BoardVO bvo = bdao.boardSelect(bseq);
   				request.setAttribute("MY_KEY_BVO", bvo);			//해당게시물의 상세내용
   				
   				// 댓글 보기
//   				ReplyDAO rdao = new ReplyDAO();
//   				List<ReplyVO> rlist = rdao.replySelect(bseq);
//   				request.setAttribute("MY_KEY_RLIST", rlist);		//해당게시물의 댓글목록
   				
   				// board_detail.jsp로 foward
   	   			request.getRequestDispatcher("/boardpage.jsp").forward(request, response);
   			} else {
   				response.sendRedirect("/500.html");
   			}
   		} else if (pageGubun.equals("TR001")) {
   			int bseq = 1;
   			
   			String bseqStr = request.getParameter("bseq");
   			
   			if(bseqStr != null && !bseqStr.equals(""))  {
   				bseq = Integer.parseInt(bseqStr);
   				
   				// 게시불의 상세보기
   				BoardVO bvo = bdao.boardReplySelect(bseq);
   				request.setAttribute("MY_KEY_BVO", bvo);			//해당게시물의 상세내용
   				
   				// board_detail.jsp로 foward
   	   			request.getRequestDispatcher("/boardpage.jsp").forward(request, response);
   			} else {
   				response.sendRedirect("/500.html");
   			}
		} 
//   ----------------------------------------------------------- 		
	}
    
}
