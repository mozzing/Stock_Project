package com.stock.reply;

/**
 * Description : 클래스에 대한 설명을 입력해주세요.
 * @packageName		: com.stock.reply
 * @fileName		: ReplyVO.java
 * @author			: Jemu Lee
 * @date			: 2025.01.03
 * @version			: 1.0
 * @description
 * ===========================================================
 * DATE			AUTHOR		NOTE
 * -----------------------------------------------------------
 * 2025.01.03	Jemu Lee	최초 생성
 */

public class ReplyVO {
	
	private int rseq;
	private String replycontents;
	private String replydate;
	private int useq;
	private int bseq;
	
	public ReplyVO() {
		
	}
	
	public ReplyVO(int rseq, String replycontents, String replydate, int useq, int bseq){
		super();
		this.rseq = rseq;
		this.replycontents = replycontents;
		this.replydate = replydate;
		this.useq = useq;
		this.bseq = bseq;
	}
	
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public String getReplycontents() {
		return replycontents;
	}
	public void setReplycontents(String replycontents) {
		this.replycontents = replycontents;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	@Override
	public String toString() {
		return "ReplyVO [rseq=" + rseq + ", replycontents=" + replycontents + ", replydate=" + replydate + ", useq="
				+ useq + ", bseq=" + bseq + "]";
	}
	
	
}
