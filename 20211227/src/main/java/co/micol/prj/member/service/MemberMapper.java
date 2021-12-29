package co.micol.prj.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface MemberMapper {

		//C.R.U.D 디폴트	
		List<MemberVO> memberSelectList();
		MemberVO memberSelect(MemberVO member); // 한명정보조회, 로그인 까지 사용
		int memberInsert(MemberVO member);
		int memberDelet(MemberVO member);
		int memberUpdate(MemberVO member);
		
		boolean isIdCheck(String id);
		
		//service 구현체 만들러 ㄱㄱ MemberServiceImpl
		
		
		//form에서 넘어오는 값임 key와 data
		List<MemberVO> memberSearch(@Param("key")String key, @Param("data")String data);
		//전달인자를 두 개 이상 받을 떄
}
