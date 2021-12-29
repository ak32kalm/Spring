package co.micol.prj.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface MemberMapper {

		//C.R.U.D ����Ʈ	
		List<MemberVO> memberSelectList();
		MemberVO memberSelect(MemberVO member); // �Ѹ�������ȸ, �α��� ���� ���
		int memberInsert(MemberVO member);
		int memberDelet(MemberVO member);
		int memberUpdate(MemberVO member);
		
		boolean isIdCheck(String id);
		
		//service ����ü ���鷯 ���� MemberServiceImpl
		
		
		//form���� �Ѿ���� ���� key�� data
		List<MemberVO> memberSearch(@Param("key")String key, @Param("data")String data);
		//�������ڸ� �� �� �̻� ���� ��
}
