package com.spring.member.dao;

import java.util.List;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {

	List selectAllMemberList();

	int insertMember(MemberVO memberVO);

	int deleteMember(String id);

}
