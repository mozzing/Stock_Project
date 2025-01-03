package com.stock.board;

/**
 * Description : 클래스에 대한 설명을 입력해주세요.
 * @packageName		: com.stock.board
 * @fileName		: BoardVO.java
 * @author			: Jemu Lee
 * @date			: 2025.01.03
 * @version			: 1.0
 * @description
 * ===========================================================
 * DATE			AUTHOR		NOTE
 * -----------------------------------------------------------
 * 2025.01.03	Jemu Lee	최초 생성
 */
public class BoardVO {
    private int bseq;
    private String title;
    private String boardcontents;
    private String boarddate;
    private int useq;
    
    
	public BoardVO() {
		super();
	}
	
	public BoardVO(int bseq, String title, String boardcontents, String boarddate, int useq) {
		super();
		this.bseq = bseq;
		this.title = title;
		this.boardcontents = boardcontents;
		this.boarddate = boarddate;
		this.useq = useq;
	}
	
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBoardcontents() {
		return boardcontents;
	}
	public void setBoardcontents(String boardcontents) {
		this.boardcontents = boardcontents;
	}
	
	public String getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}
	
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bseq=" + bseq + ", title=" + title + ", boardcontents=" + boardcontents + ", boarddate="
				+ boarddate + ", useq=" + useq + "]";
	}

    
}
