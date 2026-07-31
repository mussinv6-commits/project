package com.mbc.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mbc.project.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	// 전체 조회 (목록용)
    List<MemberDto> allmember();
    // 회원 가입
    int addmember(MemberDto dto);
    // 로그인
    MemberDto login(MemberDto dto); 
    // ID 중복확인
    int idcheck(String id);
    // 회원 상세 정보 조회 (아이디로 조회)
    MemberDto getMember(@Param("id") String id);
    // 회원 정보 수정 (내 정보 변경)
    int updateMember(MemberDto dto);
}
    

