package com.mbc.project.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BoardDto implements Serializable{
    private Long seq;               // 게시글 고유번호 (PK)
    private String writerId;        // 글 작성자 아이디 (FK)
    private String title;           // 제목
    private String content;         // 내용
    private Integer readcount;      // 조회수
    private LocalDateTime wdate;    // 작성 시간

    public BoardDto() {}

    public BoardDto(Long seq, String writerId, String title, String content, Integer readcount, LocalDateTime wdate) {
        this.seq = seq;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.readcount = readcount;
        this.wdate = wdate;
    }

    public Long getSeq() { return seq; }
    public void setSeq(Long seq) { this.seq = seq; }

    public String getWriterId() { return writerId; }
    public void setWriterId(String writerId) { this.writerId = writerId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Integer getReadcount() { return readcount; }
    public void setReadcount(Integer readcount) { this.readcount = readcount; }

    public LocalDateTime getWdate() { return wdate; }
    public void setWdate(LocalDateTime wdate) { this.wdate = wdate; }
}
