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
}
    

