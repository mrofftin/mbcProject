package com.mbc.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

   @Autowired 
   private SqlSessionFactory sqlSessionFactory;
   
   // 회원 전체 리스트 가져오기
   public List<MemberDTO> memberList() {
      SqlSession sqlSession = sqlSessionFactory.openSession();
                                    // 매개변수는 메소드명을 관례적을 사용
      List<MemberDTO> list = sqlSession.selectList("memberList");
      sqlSession.close();
      
      return list;
   }
   
   // 회원 저장
   public int memberInsert(MemberDTO dto) {
	   // openSession()의 매개변수 기본값 false, 여기서 false는 생략되었음
	   // false는 Autocommit이 false, 
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   int cnt = sqlSession.insert("memberInsert", dto);
	   sqlSession.commit(); // openSession(true)이면 sqlSession.commit()생략가능
	   sqlSession.close();
	   
	   return cnt;
   }
   
   // 회원 정보 조회하기
   public MemberDTO memberInfo(int no) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   MemberDTO dto = sqlSession.selectOne("memberInfo", no);
	   sqlSession.close();
	   
	   return dto;
   }
   
   // 회워 삭제 메소드
   public int deleteMember(int no) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   int cnt = sqlSession.delete("deleteMember", no);
	   sqlSession.commit();
	   sqlSession.close();
	   
	   return cnt;
   }
   
   // 회원 수정 메소드
   public int memberUpdate(MemberDTO dto) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   int cnt = sqlSession.update("memberUpdate", dto);
	   sqlSession.commit();
	   sqlSession.close();
	   
	   return cnt;
   }
}