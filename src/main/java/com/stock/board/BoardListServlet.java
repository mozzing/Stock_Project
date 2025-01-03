package com.stock.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detailpage")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 고유 식별자 추가
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
   		response.setContentType("text/html; charset=UTF-8");
   		
    	BoardDAO dao = new BoardDAO();
        ArrayList<BoardVO> boardList = dao.boardSelect();

        // 로그 추가: 게시물 목록 크기 확인
        System.out.println("게시물 목록 크기: " + boardList.size());
        
        // 게시물 목록을 콘솔에 출력하여 확인
        for (BoardVO board : boardList) {
            System.out.println("BSEQ: " + board.getBseq() + ", Title: " + board.getTitle() + ", Contents: " + board.getBoardcontents() + ", BOARDDATE : " + board.getBoarddate() + ", USEQ : " + board.getUseq());
        }

        // JSP로 게시물 목록 전달
        request.setAttribute("boardList", boardList);

        // boardList.jsp로 포워드
        RequestDispatcher dispatcher = request.getRequestDispatcher("/detailpage.jsp");
        dispatcher.forward(request, response);
    }
}
