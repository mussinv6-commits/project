package com.mbc.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.project.dto.BoardDto;
import com.mbc.project.service.BoardService;

@RestController
public class BoardController {

    @Autowired
    private BoardService service;


    // 1. 자유게시판 (board) 기능

    // 자유게시판 전체 목록 조회
    @PostMapping("/allboard")
    public List<BoardDto> allboard() {
        System.out.println("BoardController allboard() " + new Date());
        return service.getBoardList(); // 게시글 목록을 반환
    }

    // 자유게시판 글쓰기 등록
    @PostMapping("/addboard")
    public int addboard(@RequestBody BoardDto dto) {
        System.out.println("BoardController addboard() " + new Date());
        return service.writeBoard(dto); // 글 등록 결과를 반환
    }

    // 자유게시판 상세보기 (조회수 증가 포함)
    @PostMapping("/detailboard")
    public BoardDto detailboard(@RequestParam("seq") Long seq) {
        System.out.println("BoardController detailboard() " + new Date());
        return service.getBoardDetail(seq); // 게시글 상세 정보를 반환
    }


    // 2. 공지사항 (notice) 기능


    // 공지사항 전체 목록 조회
    @PostMapping("/allnotice")
    public List<BoardDto> allnotice() {
        System.out.println("BoardController allnotice() " + new Date());
        return service.getNoticeList(); // 공지사항 목록을 반환
    }

    // 공지사항 등록 (관리자용)
    @PostMapping("/addnotice")
    public int addnotice(@RequestBody BoardDto dto) {
        System.out.println("BoardController addnotice() " + new Date());
        return service.writeNotice(dto); // 공지 등록 결과를 반환
    }

    // 공지사항 상세보기 (조회수 증가 포함)
    @PostMapping("/detailnotice")
    public BoardDto detailnotice(@RequestParam("seq") Long seq) {
        System.out.println("BoardController detailnotice() " + new Date());
        return service.getNoticeDetail(seq); // 공지 상세 정보를 반환
    }


    // 3. Q&A 게시판 (qna) 기능


    // Q&A 질문 전체 목록 조회
    @PostMapping("/allqna")
    public List<BoardDto> allqna() {
        System.out.println("BoardController allqna() " + new Date());
        return service.getQnaList(); // 질문 목록을 반환
    }

    // Q&A 질문 등록 (사용자용)
    @PostMapping("/addqna")
    public int addqna(@RequestBody BoardDto dto) {
        System.out.println("BoardController addqna() " + new Date());
        return service.writeQna(dto); // 질문 등록 결과를 반환
    }

    // Q&A 상세보기 (조회수 증가 포함)
    @PostMapping("/detailqna")
    public BoardDto detailqna(@RequestParam("seq") Long seq) {
        System.out.println("BoardController detailqna() " + new Date());
        return service.getQnaDetail(seq); // 질문 및 답변 정보를 반환
    }

    // Q&A 관리자 답변 등록 및 완료 처리
    @PostMapping("/answerqna")
    public int answerqna(@RequestBody BoardDto dto) {
        System.out.println("BoardController answerqna() " + new Date());
        return service.answerQna(dto); // 답변 등록 결과를 반환
    }
}
