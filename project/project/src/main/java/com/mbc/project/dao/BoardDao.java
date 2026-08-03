package com.mbc.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mbc.project.dto.BoardDto;
import com.mbc.project.dto.MemberDto;

@Mapper // 스프링부트에 DB와의 소통한다고 알려주는 애노테이션(Annotation)
public interface BoardDao {
    // 1. 자유게시판 (board)
    List<BoardDto> allboard();      // 게시글 전체 목록 조회
    int addboard(BoardDto dto);     // 게시글 등록 (글쓰기)
    BoardDto detailboard(Long seq); // 게시글 상세 조회 (상세보기)
    int updatereadcount(Long seq);  // 조회수 1 증가

    // 2. 공지사항 (notice)
    List<BoardDto> allnotice();          // 공지사항 전체 목록 조회
    int addnotice(BoardDto dto);         // 공지사항 등록 (관리자 글쓰기)
    BoardDto detailnotice(Long seq);     // 공지사항 상세 조회 (상세보기)
    int updatenoticecount(Long seq);     // 공지사항 조회수 1 증가

    // 3. Q&A 게시판 (qna)
    List<BoardDto> allqna();             // Q&A 질문 전체 목록 조회
    int addqna(BoardDto dto);            // Q&A 질문 등록 (사용자 질문하기)
    BoardDto detailqna(Long seq);        // Q&A 상세 조회 (비밀글 및 답변 내용 확인)
    int updateqnacount(Long seq);        // Q&A 조회수 1 증가
    int answerqna(BoardDto dto);         // Q&A 관리자 답변 등록 및 수정 (답변 완료 처리)

}