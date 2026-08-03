package com.mbc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.project.dao.BoardDao;
import com.mbc.project.dto.BoardDto;

@Service // 스프링부트에 비즈니스 로직(서비스)을 처리한다고 알려주는 애노테이션(Annotation)
public class BoardService {

    @Autowired
    private BoardDao boardDao; // Dao 가져오기 

    // ==========================================
    // 1. 자유게시판 (board) 기능
    // ==========================================
    
    // 자유게시판 목록 가져오기
    public List<BoardDto> getBoardList() {
        return boardDao.allboard();
    }

    // 자유게시판 글쓰기
    public int writeBoard(BoardDto dto) {
        return boardDao.addboard(dto);
    }

    // ⭐ 자유게시판 상세보기 (조회수 증가 + 글 가져오기를 동시에 처리!)
    public BoardDto getBoardDetail(Long seq) {
        boardDao.updatereadcount(seq); // 1. 먼저 조회수를 1 올리고
        return boardDao.detailboard(seq); // 2. 그 다음 글 내용을 가져온다
    }
    // ==========================================
    // 2. 공지사항 (notice) 기능
    // ==========================================
    
    // 공지사항 목록 가져오기
    public List<BoardDto> getNoticeList() {
        return boardDao.allnotice();
    }

    // 공지사항 글쓰기
    public int writeNotice(BoardDto dto) {
        return boardDao.addnotice(dto);
    }

    // ⭐ 공지사항 상세보기 (조회수 증가 + 글 가져오기를 동시에 처리!)
    public BoardDto getNoticeDetail(Long seq) {
        boardDao.updatenoticecount(seq);   // 1. 먼저 공지사항 조회수를 1 올리고
        return boardDao.detailnotice(seq); // 2. 그 다음 공지글 내용을 가져온다
    }


    // ==========================================
    // 3. Q&A 게시판 (qna) 기능
    // ==========================================
    
    // Q&A 질문 목록 가져오기
    public List<BoardDto> getQnaList() {
        return boardDao.allqna();
    }

    // Q&A 질문 쓰기 (사용자 질문등록)
    public int writeQna(BoardDto dto) {
        return boardDao.addqna(dto);
    }

    // ⭐ Q&A 상세보기 (조회수 증가 + 글 가져오기를 동시에 처리!)
    public BoardDto getQnaDetail(Long seq) {
        boardDao.updateqnacount(seq);   // 1. 먼저 Q&A 조회수를 1 올리고
        return boardDao.detailqna(seq); // 2. 그 다음 질문 및 답변 내용을 가져온다
    }

    // Q&A 관리자 답변 등록하기
    public int answerQna(BoardDto dto) {
        return boardDao.answerqna(dto);
    }
}