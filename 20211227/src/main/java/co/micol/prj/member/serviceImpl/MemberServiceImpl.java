package co.micol.prj.member.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.member.service.MemberMapper;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

//IOC �����̳ʿ� memberDao�̸����� ���ԵǶ� 
@Repository("memberDao") // @Service, @Component�� �����մϴ�. �ƹ��ų� ������.
public class MemberServiceImpl implements MemberService{
	
	@Autowired // 
	private MemberMapper map; //  IoC�� �ִ� SqlSessionTemplate(org.mybatis.spring.SqlSessionTemplate)�� map�̶�� �̸����� �ڵ����� �϶�

	@Override
	public List<MemberVO> memberSelectList() {
		// return map.;  member-map ������
		
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO member) {
		// TODO Auto-generated method stub
		return map.memberSelect(member);
	}

	@Override
	public int memberInsert(MemberVO member) {
		return map.memberInsert(member);
	}

	@Override
	public int memberDelet(MemberVO member) {
		// TODO Auto-generated method stub
		return map.memberDelet(member);
	}

	@Override
	public int memberUpdate(MemberVO member) {
		return map.memberUpdate(member);
	}

	@Override
	public boolean isIdCheck(String id) {
		return map.isIdCheck(id);
	}

	@Override
	public List<MemberVO> memberSearch(String key, String data) {
		return map.memberSearch(key, data);
	}
	
}
