package com.stock.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.common.DBManager;
import com.stock.common.OracleDBManager;

/**
 * Description : 클래스에 대한 설명을 입력해주세요.
 * @packageName		: com.stock.reply
 * @fileName		: ReplyDAO.java
 * @author			: Jemu Lee
 * @date			: 2025.01.03
 * @version			: 1.0
 * @description
 * ===========================================================
 * DATE			AUTHOR		NOTE
 * -----------------------------------------------------------
 * 2025.01.03	Jemu Lee	최초 생성
 */

public class ReplyDAO {
	
	public List<ReplyVO> replySelect(int bseq){
		
		List<ReplyVO> replylist = new ArrayList<ReplyVO>();
		
		DBManager dbm = OracleDBManager.getInstance();
		
		Connection conn = dbm.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			String sql = "select * from reply where bseq = ? order by rseq asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyVO reply = new ReplyVO();
				
				reply.setRseq( rs.getInt("RSEQ") );
				reply.setReplycontents( rs.getString("REPLYCONTENTS"));
				reply.setReplydate( rs.getString("REPLYDATE"));
				reply.setUseq( rs.getInt("USEQ"));
				reply.setUseq( rs.getInt("BSEQ"));
				
				replylist.add(reply);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		return replylist;
	}
	
	public int replyInsert(ReplyVO reply) {
		DBManager dbm = OracleDBManager.getInstance();
		
		Connection conn = dbm.connect();
		
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			String sql = "insert into reply(rseq, replycontents, useq, bseq) values(seq_myreply.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getReplycontents());
			pstmt.setInt(2, reply.getUseq());
			pstmt.setInt(3, reply.getBseq());
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
		
		return rows;
	}
	
	public int replyDelete(int rseq) {
        DBManager dbm = OracleDBManager.getInstance();
        
        Connection conn = dbm.connect();
        PreparedStatement pstmt = null;
        
        int rows = 0;

        try {
            String sql = "delete from reply where rseq = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rseq); // 파라미터를 1번째 ?에 바인딩
            
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbm.close(conn, pstmt);
        }

        return rows;
    }
	
//	public static void main(String[] args) {
//		ReplyDAO dao = new ReplyDAO();
//		
//		// 1. 특정 bseq에 대한 댓글 목록 가져오기
//		List<ReplyVO> replies = dao.replySelect(1);
//		for(ReplyVO reply : replies) {
//			System.out.println(reply.toString());
//		}
//		
//		System.out.println("----------");
//		
//		 2. 새로운 댓글 삽입
//		ReplyVO newReply = new ReplyVO();
//		newReply.setReplycontents("test1");
//		newReply.setUseq(1);
//		newReply.setBseq(2);
//		
//		int insertResult = dao.replyInsert(newReply);
//		System.out.println("삽입된 행 수: " + insertResult);
//		
//		
//		
//		// 3. 댓글 삭제
//		int deleteResult = dao.replyDelete(29);
//		System.out.println("삭제된 행 수: " + deleteResult);
//	}
}
