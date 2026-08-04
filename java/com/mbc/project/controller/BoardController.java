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






}
