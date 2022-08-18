package com.spring.ex04;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper = null;
	
	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance(); //가상주소 매핑(db정도 등등)
		SqlSession session = sqlMapper.openSession(); //실질적 주소연결(session객체에)
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
	public MemberVO selectMemberById(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberVO memberVO = (MemberVO) session.selectOne("mapper.member.selectMemberById",id);
		return memberVO;
	}
	public List<MemberVO> selectMemberByPwd(int pwd) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> membersList = null;
		membersList = session.selectList("mapper.member.selectMemberByPwd",pwd);
		return membersList;
}
	public int insertMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = 0 ;
		result = session.insert("mapper.member.insertMember",memberVO);
		session.commit();
		return result;
	}
	public int insertMember2(Map<String,String> memberMap) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.insertMember2",memberMap);
		session.commit();
		return result;
	}
	public int updateMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.update("mapper.member.updateMember",memberVO);
		// update문 호출 시 SqlSession의 update()메서드를 이용한다.
		session.commit();
		return result;
	}
	public int deleteMember(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = 0;
		result = session.delete("mapper.member.deleteMember",id);
		// delete문을 실행하려면 SqlSession의 delete()메서드 이용해야한다.
		session.commit();
		return result;
	}
	public List<MemberVO> searchMember(MemberVO memberVO){
		sqlMapper=getInstance();
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("mapper.member.searchMember",memberVO);
		//회원 검색창에서 전달된 이름과 나이 값을 memberVO에 설정하여 SQL문으로 전달
		return list;
	}
	public List<MemberVO> foreachSelect(List nameList){
		sqlMapper =getInstance();
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("mapper.member.foreachSelect",nameList);
		//검색 이름이 저장된 nameList를 SQL문으로 전달합니다.
		return list;
	}
	public int foreachInsert(List memList) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.foreachInsert",memList);
		session.commit();
		return result;
	}
	public List<MemberVO> selectLike(String name){
		sqlMapper =getInstance();
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("mapper.member.selectLike", name);
		return list;
	}
}
