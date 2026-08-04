package com.mbc.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mbc.project.dto.BoardDto;
import com.mbc.project.dto.QnaDto;

@Mapper // 스프링부트에 DB와의 소통한다고 알려주는 애노테이션(Annotation)
public interface QnaDao {

    // 3. Q&A 게시판 (qna)
    List<QnaDto> allqna();             // Q&A 질문 전체 목록 조회
    int addqna(QnaDto dto);            // Q&A 질문 등록 (사용자 질문하기)
    QnaDto detailqna(Long seq);        // Q&A 상세 조회 (비밀글 및 답변 내용 확인)
    int updateqnacount(Long seq);        // Q&A 조회수 1 증가
    int answerqna(QnaDto dto);
}
