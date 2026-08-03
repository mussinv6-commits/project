package com.mbc.project.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BoardDto implements Serializable {

	    // 1. 공통 필드 (자유게시판, 공지사항, Q&A 공통)
	    private Long seq;               // 게시글 고유번호 (PK)
	    private String writerId;        // 글 작성자 아이디 (FK)
	    private String title;           // 제목
	    private String content;         // 내용
	    private Integer readcount;      // 조회수
	    private LocalDateTime wdate;    // 작성 시간
	    
	    // 백엔드/프론트엔드 구분용 추가 필드
	    private String boardType;       // 게시판 종류 (BOARD, NOTICE, QNA)

	    // 2. 공지사항 전용 필드
	    private Boolean ispinned;       // 상단 고정 여부

	    // 3. Q&A 전용 필드
	    private Boolean issecret;       // 비밀글 여부
	    private String status;          // 답변 상태 (WAITING / COMPLETED)
	    private String replycontent;    // 관리자 답변 내용
	    private LocalDateTime replydate;// 관리자 답변 작성 시간

    // 기본 생성자
    public BoardDto() {
    	}

	public BoardDto(Long seq, String writerId, String title, String content, Integer readcount, LocalDateTime wdate,
			String boardType, Boolean ispinned, Boolean issecret, String status, String replycontent,
			LocalDateTime replydate) {
		super();
		this.seq = seq;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.readcount = readcount;
		this.wdate = wdate;
		this.boardType = boardType;
		this.ispinned = ispinned;
		this.issecret = issecret;
		this.status = status;
		this.replycontent = replycontent;
		this.replydate = replydate;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReadcount() {
		return readcount;
	}

	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public Boolean getIspinned() {
		return ispinned;
	}

	public void setIspinned(Boolean ispinned) {
		this.ispinned = ispinned;
	}

	public Boolean getIssecret() {
		return issecret;
	}

	public void setIssecret(Boolean issecret) {
		this.issecret = issecret;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public LocalDateTime getReplydate() {
		return replydate;
	}

	public void setReplydate(LocalDateTime replydate) {
		this.replydate = replydate;
	}
}





