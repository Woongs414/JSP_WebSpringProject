package com.spring.member.service;

import java.util.List;

import com.spring.member.vo.MemberVO;

public interface MemberService {

	List listMembers();

	int addMember(MemberVO memberVO);

	int removeMember(String id);

}
