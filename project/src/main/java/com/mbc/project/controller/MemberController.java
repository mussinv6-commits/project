package com.mbc.project.controller;

import java.util.ArrayList;
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
	
	@PostMapping("/allmember")
	public List<MemberDto> allmember(){
	
		List<MemberDto> dto = new ArrayList<>();
		

		 return service.allMemberDao();
	}

}