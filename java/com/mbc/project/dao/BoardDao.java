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



}