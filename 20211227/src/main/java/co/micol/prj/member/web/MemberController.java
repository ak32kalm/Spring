package co.micol.prj.member.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

@Controller // ���� ��Ʈ�ѷ�����
public class MemberController {

	
	
	
	@Autowired
	private MemberService memberDao; // dao�� �ڵ������ϴ� �̴ϴ�.

	// ������� ��Ǯ�� memberDao�̸����� ����ü�� ��ϵǾ�����

	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) { // �� ��ü : ����� �Ǿ ������ �������� ������

		// member��� ������ �ڿ��� ��Ƽ�
		model.addAttribute("members", memberDao.memberSelectList());
		return "member/memberSelectList";
		// memberSelectList.jsp ���鷯
	}

//	@PostMapping("/memberJoin.do") //post������� ����, get ����ϋ��� 403 ����
//	public String memberJoin(MemberVO member, Model model) {
//		return "member/memberJoin";
//	}
//	
//	@GetMapping("/memberRead.do") //get������� ����, post����϶��� 403 ����
//	public String memberRead(String id, Model model) {
//		return "member/memberRead";
//	}

	@RequestMapping("/memberLoginForm.do") // list,form �ܼ��� �Է����� ȣ���Ҷ� request
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}

	// �������� session��ü�� ������ ����
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO member, Model model, HttpSession session) { // form ��ü name="" ���� MemberVO�� ��ġ�ϸ�
																					// �ڵ����� ���Ե�.
		member = memberDao.memberSelect(member);
		if (member != null) {
			session.setAttribute("id", member.getId()); // ���ǿ� ���̵� ��´�.
			session.setAttribute("author", member.getAuthor()); // ���ǿ� ������ ��´�.
			model.addAttribute("message", member.getName() + "�� ȯ���մϴ�.");

		} else {
			model.addAttribute("message", "���̵� �Ǵ� �н����尡 Ʋ���ϴ�.");
		}
		return "member/memberLogin";// jsp ���鷯 ����
	}

	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
			//session�� ���ֹ����� Logout�� ��
			session.invalidate();	// session�� �������� �����Ѵ�.
			model.addAttribute("message", "�α׾ƿ��� ���������� ó�� �Ǿ����ϴ�.");
			
		return "member/memberLogout"; //jsp ���鷯 ����
		
	}
	
	@PostMapping("/ajaxSearchMember.do")
	@ResponseBody //ajax ȣ���������� �������  
	public List<MemberVO> ajaxSearchMember(@RequestParam("key") String key, @RequestParam("data") String data){
		return memberDao.memberSearch(key, data); 
	}
	
	@RequestMapping("/memberJoinForm.do") //ȸ������ �� ȣ��
	public String memberJoinFrom() {
		return "member/memberJoinForm";
	}

	@PostMapping("/memberJoin.do") //ȸ������ //id�� file�̶� �ָ�  MultipartFile�̶� ��ü�� file���� ��ڴ� //�������ֵ��� MeberVO��ü�� ��� 
	public String memberJoin(@RequestParam("file")MultipartFile file, MemberVO member, Model model) {
		int n = memberDao.memberInsert(member);
		if(n != 0) {
			model.addAttribute("message","ȸ�������� ���� �Ǿ����ϴ�");
			
		}else {
			model.addAttribute("message","ȸ�������� ���� �߽��ϴ�.");
		}
		
		return "member/memberJoin";
	}
	
	@PostMapping("/ajaxIsidCheck.do") //���̵� �ߺ�üũ
	@ResponseBody
	public boolean ajaxIsidCheck(String id) {
		boolean b = memberDao.isIdCheck(id);
		return b;
	}
}
