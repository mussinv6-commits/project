package com.mbc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.project.dao.QnaDao;
import com.mbc.project.dto.QnaDto;

@Service
public class QnaService {

    @Autowired
    private QnaDao qnaDao;

    // ==========================================
    // 3. Q&A 게시판 (qna) 기능
    // ==========================================

    // Q&A 질문 목록 가져오기
    public List<QnaDto> getQnaList() {
        return qnaDao.allqna();
    }

    // Q&A 질문 쓰기 (사용자 질문등록)
    public int writeQna(QnaDto dto) {
        return qnaDao.addqna(dto);
    }

    // ⭐ Q&A 상세보기 (조회수 증가 + 글 가져오기를 동시에 처리!)
    public QnaDto getQnaDetail(Long seq) {
        qnaDao.updateqnacount(seq);   // 1. 먼저 Q&A 조회수를 1 올리고
        return qnaDao.detailqna(seq); // 2. 그 다음 질문 및 답변 내용을 가져온다
    }

    // Q&A 관리자 답변 등록하기
    public int answerQna(QnaDto dto) {
        return qnaDao.answerqna(dto);
    }
}