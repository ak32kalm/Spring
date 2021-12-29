package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {

	//C.R.U.D ����Ʈ
	
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO member); // �Ѹ�������ȸ, �α��� ���� ���
	int memberInsert(MemberVO member);
	int memberDelet(MemberVO member);
	int memberUpdate(MemberVO member);
	
	boolean isIdCheck(String id);
	
	//mapper interface ���鷯 ����

	List<MemberVO> memberSearch(String key, String data); //
}
