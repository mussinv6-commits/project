package com.mbc.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.project.dto.MemberDto;
import com.mbc.project.service.MemberService;

@RestController
public class MemberController {
	
	final MemberService service;
	
	MemberController(MemberService service) {
		this.service = service;
	}
	// 전체 회원조회
	@PostMapping("/allmember")
	public List<MemberDto> allmember(){
		System.out.println("MemberController allmember()" + new Date());

		 return service.allMemberDao();
	}
	// 회원가입
	@PostMapping("/addmember")
	public boolean addmember(@RequestBody MemberDto dto) {
		System.out.println("MemberController addmember()" + new Date());
		
		return service.addmember(dto);
	}
	// 로그인
	@PostMapping("/login")
	public MemberDto login(MemberDto dto) {
		System.out.println("MemberController login() " + new Date());
		
		return service.login(dto);
	}
	// 아이디 중복확인
	@PostMapping("/idcheck")
	public boolean idcheck(String id) {
		System.out.println("MemberController idcheck()" + new Date());
		
		return service.idcheck(id);	
	}
	
	
}