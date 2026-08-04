package com.mbc.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mbc.project.dto.BoardDto;
import com.mbc.project.dto.NoticeDto;

@Mapper // 스프링부트에 DB와의 소통한다고 알려주는 애노테이션(Annotation)
public interface NoticeDao {
    // 2. 공지사항 (notice)
    List<NoticeDto> allnotice();          // 공지사항 전체 목록 조회
    int addnotice(NoticeDto dto);         // 공지사항 등록 (관리자 글쓰기)
    NoticeDto detailnotice(Long seq);     // 공지사항 상세 조회 (상세보기)
    int updatenoticecount(Long seq);     // 공지사항 조회수 1 증가

}
