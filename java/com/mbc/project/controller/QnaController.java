package com.mbc.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.project.dto.BoardDto;
import com.mbc.project.dto.QnaDto;
import com.mbc.project.service.QnaService;


@RestController
public class QnaController {

    @Autowired
    private QnaService qnaService;   // ← 여기! 클래스 필드로 선언

    // 3. Q&A 게시판 (qna) 기능

    // Q&A 질문 전체 목록 조회
    @PostMapping("/allqna")
    public List<QnaDto> allqna() {
        System.out.println("QnaController allqna() " + new Date());
        return qnaService.getQnaList();
    }

    @PostMapping("/addqna")
    public int addqna(@RequestBody QnaDto dto) {
        System.out.println("QnaController addqna() " + new Date());
        return qnaService.writeQna(dto);
    }

    @PostMapping("/detailqna")
    public QnaDto detailqna(@RequestParam("seq") Long seq) {
        System.out.println("QnaController detailqna() " + new Date());
        return qnaService.getQnaDetail(seq);
    }

    @PostMapping("/answerqna")
    public int answerqna(@RequestBody QnaDto dto) {
        System.out.println("QnaController answerqna() " + new Date());
        return qnaService.answerQna(dto);
    }
}