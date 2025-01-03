package com.stock.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.stock.board.BoardVO;
import com.stock.common.DBManager;
import com.stock.common.OracleDBManager;



public class BoardDAO {

	/**
	 * Description : 모든 게시물 검색 메소드
	 * detailpage.jsp에 사용
	 * @methodName    : boardSelect
	 * @author        : Jemu Lee
	 * @date          : 2025.01.03
	 * @return boardList
	 */
	public ArrayList<BoardVO> boardSelect() {

		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();	// 결과를 저장할 리스트 생성
		
		DBManager dbm = OracleDBManager.getInstance();  	// DB 관리 객체 생성
		
		Connection conn = dbm.connect();					// DB 연결
		PreparedStatement pstmt = null;						// SQL 실행 준비 객체 초기화
		ResultSet rs = null;								// 실행 결과를 담을 객체 초기화
		
		try {
			String sql = "select b.bseq, b.title, b.boardcontents, b.boarddate, b.useq\r\n"
					+ "from board b";
			
			pstmt =  conn.prepareStatement(sql);			// SQL 쿼리를 준비
			rs = pstmt.executeQuery();						// 쿼리 실행 후 결과 저장
			
			while(rs.next()) {								// 결과 집합에서 각 행의 반복 처리
				BoardVO bvo = new BoardVO();				// DB행을 객체로 매핑
				bvo.setBseq(  rs.getInt("BSEQ")     );
				bvo.setTitle(  rs.getString("TITLE")  );
				bvo.setBoardcontents(  rs.getString("BOARDCONTENTS")  );
				bvo.setBoarddate(  rs.getString("BOARDDATE")  );
				bvo.setUseq(rs.getInt("USEQ"));
				
				boardList.add(bvo);							// 리스트에 객체 추가
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
				dbm.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	/**
	 * Description : 특정 게시물만 조회하는 메소드
	 * boardpage.jsp에 사용
	 * @methodName    : boardSelect
	 * @author        : Jemu Lee
	 * @date          : 2025.01.03
	 * @param bseq
	 * @return
	 */
	public BoardVO boardSelect(int bseq) {
		
		BoardVO bvo = new BoardVO();
		
		DBManager dbm = OracleDBManager.getInstance();
		
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from board where bseq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);			// 파라미터를 1번째 ?에 바인딩
			
			rs = pstmt.executeQuery();
			rs.next();
			
			bvo.setBseq( rs.getInt("BSEQ"));
			bvo.setTitle( rs.getString("TITLE"));
			bvo.setBoardcontents( rs.getString("BOARDCONTENTS"));
			bvo.setBoarddate( rs.getString("BOARDDATE"));
			bvo.setUseq( rs.getInt("USEQ"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return bvo;
	}
	

}