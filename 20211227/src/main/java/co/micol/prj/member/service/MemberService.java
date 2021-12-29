package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {

	//C.R.U.D 디폴트
	
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO member); // 한명정보조회, 로그인 까지 사용
	int memberInsert(MemberVO member);
	int memberDelet(MemberVO member);
	int memberUpdate(MemberVO member);
	
	boolean isIdCheck(String id);
	
	//mapper interface 만들러 ㄱㄱ

	List<MemberVO> memberSearch(String key, String data); //
}
