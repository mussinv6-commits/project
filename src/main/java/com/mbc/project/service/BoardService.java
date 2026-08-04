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



}