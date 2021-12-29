package co.micol.prj.member.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.member.service.MemberMapper;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

//IOC 컨테이너에 memberDao이름으로 포함되라 
@Repository("memberDao") // @Service, @Component와 동일합니다. 아무거나 쓰세요.
public class MemberServiceImpl implements MemberService{
	
	@Autowired // 
	private MemberMapper map; //  IoC에 있는 SqlSessionTemplate(org.mybatis.spring.SqlSessionTemplate)를 map이라는 이름으로 자동주입 하라

	@Override
	public List<MemberVO> memberSelectList() {
		// return map.;  member-map 만들고와
		
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
