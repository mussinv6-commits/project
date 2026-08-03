package com.mbc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.project.dao.NoticeDao;
import com.mbc.project.dto.BoardDto;
import com.mbc.project.dto.NoticeDto;

@Service
public class NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    // ==========================================
    // 2. 공지사항 (notice) 기능
    // ==========================================

    // 공지사항 목록 가져오기
    public List<NoticeDto> getNoticeList() {
        return noticeDao.allnotice();
    }

    // 공지사항 글쓰기
    public int writeNotice(NoticeDto dto) {
        return noticeDao.addnotice(dto);
    }

    // ⭐ 공지사항 상세보기 (조회수 증가 + 글 가져오기를 동시에 처리!)
    public NoticeDto getNoticeDetail(Long seq) {
        noticeDao.updatenoticecount(seq);   // 1. 먼저 공지사항 조회수를 1 올리고
        return noticeDao.detailnotice(seq); // 2. 그 다음 공지글 내용을 가져온다
    }

}