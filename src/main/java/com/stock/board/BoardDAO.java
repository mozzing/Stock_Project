package com.stock.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stock.common.DBManager;
import com.stock.common.OracleDBManager;
import com.stock.reply.ReplyVO;



public class BoardDAO {
	
	
	/**
	 * Description : 게시물과 댓글을 함께 검색하는 쿼리문
	 * 
	 * @methodName    : myboardReplySelect
	 * @author        : Jemu Lee
	 * @date          : 2025.01.06
	 * @param bseq
	 * @return
	 */
	public BoardVO boardReplySelect(int bseq) {
		
		//DBManager dbm = OracleDBManager.getInstance();    //new OracleDBManager();
		DBManager dbm = OracleDBManager.getInstance();  		//new MariaDBManager();
		
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO bvo = null;
		
		try {
			String sql = "select b.*, r.*\r\n"
					+ "from (select * from board where bseq = ?) b, reply r\r\n"
					+ "where b.bseq = r.bseq";
			pstmt =  conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);	//------파라미터를 1번째?에 바인딩
			
			rs = pstmt.executeQuery();  
			
			ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();
			
			while( rs.next() ) {
				//-------------------------------------------------
				// ORM 1:N 효과 
				//-------------------------------------------------
				ReplyVO rvo = new ReplyVO();
				
				// 처음 루프에서는 상세보기와 댓글하나만 담기
				if(bvo == null) {
					// 상세는 (1)번만 담기
					bvo = new BoardVO();
									
					bvo.setBseq(  rs.getInt("BSEQ")     );
					bvo.setTitle(  rs.getString("TITLE")  );
					bvo.setBoardcontents(  rs.getString("BOARDCONTENTS")  );
					bvo.setBoarddate(  rs.getString("BOARDDATE")  );
					bvo.setUseq(rs.getInt("USEQ"));
				}
				// 댓글을 (N)개 담기
				rvo.setRseq( rs.getInt("RSEQ") );
				rvo.setReplycontents( rs.getString("REPLYCONTENTS"));
				rvo.setReplydate( rs.getString("REPLYDATE"));
				rvo.setUseq( rs.getInt("USEQ"));
				rvo.setUseq( rs.getInt("BSEQ"));
				
				rlist.add(rvo);
			}
			bvo.setRlist(rlist);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbm.close(conn, pstmt, rs);
		}
		return bvo;
	}
	
	/**
	 * Description : page 구분자
	 * 
	 * @methodName    : myboardSelect
	 * @author        : Jemu Lee
	 * @date          : 2025.01.06
	 * @param searchGubun
	 * @param searchStr
	 * @return
	 */
	public ArrayList<BoardVO> boardSelect(String searchGubun, String searchStr) {
		
		ArrayList<BoardVO> alist = new ArrayList<BoardVO>();
		
		DBManager dbm = OracleDBManager.getInstance();  	//new OracleDBManager();
		
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from board where " + searchGubun + " like ? order by regdate desc";
			pstmt =  conn.prepareStatement(sql);
			
			// sql에서 like를 사용하기 위해서
			pstmt.setString(1, '%' + searchGubun + '%');
			
			rs = pstmt.executeQuery();  
			
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				
				bvo.setBseq(  rs.getInt("BSEQ")     );
				bvo.setTitle(  rs.getString("TITLE")  );
				bvo.setBoardcontents(  rs.getString("BOARDCONTENTS")  );
				bvo.setBoarddate(  rs.getString("BOARDDATE")  );
				bvo.setUseq(rs.getInt("USEQ"));
				
				alist.add(bvo);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
				dbm.close(conn, pstmt, rs);
		}
		return alist;
	}
	
	
	/**
	 * Description : paging처리
	 * 
	 * @methodName    : myboardSelect
	 * @author        : Jemu Lee
	 * @date          : 2025.01.06
	 * @param startSeq
	 * @param endSeq
	 * @return
	 */
	public ArrayList<BoardVO> boardSelect(int startSeq , int endSeq) {
		
		ArrayList<BoardVO> alist = new ArrayList<BoardVO>();
		
		DBManager dbm = OracleDBManager.getInstance();  	//new OracleDBManager();
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			String sql = "select s.*\r\n"
					+ "from (  select board.*, (ROW_NUMBER() OVER(order by boarddate desc)) as rnum \r\n"
					+ "        from board) s \r\n"
					+ "where  rnum between ? and ?";
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setInt(1, startSeq);
			pstmt.setInt(2, endSeq);
			
			rs = pstmt.executeQuery();  
			
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
								
				bvo.setBseq(  rs.getInt("BSEQ")     );
				bvo.setTitle(  rs.getString("TITLE")  );
				bvo.setBoardcontents(  rs.getString("BOARDCONTENTS")  );
				bvo.setBoarddate(  rs.getString("BOARDDATE")  );
				bvo.setUseq(rs.getInt("USEQ"));
				
				alist.add(bvo);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
				dbm.close(conn, pstmt, rs);
		}
		return alist;
	}

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
	 * Description : 단건 조회하는 메소드
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
	
	public int boardInsert(BoardVO bvo) {
		DBManager dbm  = OracleDBManager.getInstance();  //new OracleDBManager();
		
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		
		int rows=0;
		
		try {
			String sql = "insert into board(bseq, title, boardcontents, useq)\r\n"
					+ "values(seq_board.nextval, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getBoardcontents());
			pstmt.setInt(3, bvo.getUseq());
			
			rows = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
		return rows;
	}
	
	public int boardUpdate(String title, String contents, int bseq) {
		DBManager dbm  = OracleDBManager.getInstance();  //new OracleDBManager();
		
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		
		int rows = 0;
		
		try {
			String sql = "update board \r\n"
					+ "set title=? , boardcontents = ? \r\n"
					+ "where bseq=?";
			
			pstmt =  conn.prepareStatement(sql);
			
			pstmt.setString(1, title);	//------파라미터를 1번째?에 바인딩
			pstmt.setString(2, contents);
			pstmt.setInt(3, bseq);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbm.close(conn, pstmt);
		}
		return rows;
	}
	
	public int boardDelete(int bseq) {
		
		DBManager dbm  = OracleDBManager.getInstance();  //new OracleDBManager();
		
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		
		int rows = 0;
		
		try {
			String sql = "delete from board where bseq=?";
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);	//------파라미터를 1번째?에 바인딩
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbm.close(conn, pstmt);
		}
		return rows;
	}	
	
	
 	//--------- 호출 테스트 ---------
//	public static void main(String[] args) throws InterruptedException  {
//		
//		BoardDAO o = new BoardDAO();
//		//게시물, 댓글 호출 테스트
//		BoardVO result = o.boardReplySelect(2);
//		System.out.println("게시물 + 댓글 조회");
//
//		if (result != null) {
//		    System.out.println("게시물: " + result.toString());
//		    System.out.println("댓글 목록:");
//		    for (ReplyVO reply : result.getRlist()) {
//		        System.out.println(reply.toString());
//		    }
//		} else {
//		    System.out.println("게시물이 없습니다.");
//		}
//		System.out.println("----------");
//		
//		// paging 처리 테스트
//		ArrayList<BoardVO> list = o.boardPaging(1, 2);
//		System.out.println("페이징 테스트 : ");
//		for(BoardVO vo: list) {
//			System.out.println(vo.toString());
//		}
//		System.out.println("----------");
//		
//		ArrayList<BoardVO> res2 = o.boardSelect();
//		System.out.println("전체 게시물 조회");
//		for(BoardVO evo : res2)
//			System.out.println(evo.toString());
//		
//		System.out.println("----------");
//		
//		BoardVO vo = o.boardSelect(1);
//		System.out.println("일부 게시물 조회 :" + vo.toString() + "\n");
//	
//		BoardVO mm = new BoardVO();
//		mm.setTitle("titlte");
//		mm.setBoardcontents("ccccccc");
//		mm.setUseq(11);
//		
//		int res3 = o.boardInsert(mm);
//		System.out.println("insert 테스트 :" + res3 + "\n");
//	
//		int res4 = o.boardUpdate("title수정테스트!!!!", "게시글 수정테스트!!!!!!!", 12);
//		System.out.println("update 테스트 :" + res4 + "\n");
//		
//		int res5 = o.boardDelete(12);
//		System.out.println("delete 테스트 :" + res5 + "\n");
//		
//		ArrayList<BoardVO> res10 = o.boardSelect();
//		System.out.println("전체 게시물 조회");
//		for(BoardVO evo : res10)
//			System.out.println(evo.toString());
//	}
}