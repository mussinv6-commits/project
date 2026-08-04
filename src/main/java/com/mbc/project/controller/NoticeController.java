package com.mbc.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.project.dao.QnaDao;
import com.mbc.project.dto.BoardDto;
import com.mbc.project.dto.NoticeDto;
import com.mbc.project.service.NoticeService;

@RestController
public class NoticeController {
    // 2. 공지사항 (notice) 기능

    @Autowired
    private NoticeService noticeService;
	
    // 공지사항 전체 목록 조회
    @PostMapping("/allnotice")
    public List<NoticeDto> allnotice() {
        System.out.println("BoardController allnotice() " + new Date());
        return noticeService.getNoticeList(); // 공지사항 목록을 반환
    }

    // 공지사항 등록 (관리자용)
    @PostMapping("/addnotice")
    public int addnotice(@RequestBody NoticeDto dto) {
        System.out.println("BoardController addnotice() " + new Date());
        return noticeService.writeNotice(dto); // 공지 등록 결과를 반환
    }

    // 공지사항 상세보기 (조회수 증가 포함)
    @PostMapping("/detailnotice")
    public NoticeDto detailnotice(@RequestParam("seq") Long seq) {
        System.out.println("BoardController detailnotice() " + new Date());
        return noticeService.getNoticeDetail(seq); // 공지 상세 정보를 반환
    }

}
