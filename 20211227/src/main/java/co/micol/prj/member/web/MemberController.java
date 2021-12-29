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

@Controller // 나는 콘트롤러에요
public class MemberController {

	
	
	
	@Autowired
	private MemberService memberDao; // dao를 자동주입하는 겁니다.

	// 멤버서비스 임풀이 memberDao이름으로 구현체에 등록되어있음

	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) { // 모델 객체 : 결과를 실어서 전달할 페이지에 던져줌

		// member라는 변수에 뒤에걸 담아서
		model.addAttribute("members", memberDao.memberSelectList());
		return "member/memberSelectList";
		// memberSelectList.jsp 만들러
	}

//	@PostMapping("/memberJoin.do") //post방식으로 전달, get 방식일떄는 403 오류
//	public String memberJoin(MemberVO member, Model model) {
//		return "member/memberJoin";
//	}
//	
//	@GetMapping("/memberRead.do") //get방식으로 전달, post방식일때는 403 오류
//	public String memberRead(String id, Model model) {
//		return "member/memberRead";
//	}

	@RequestMapping("/memberLoginForm.do") // list,form 단순히 입력폼을 호출할때 request
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}

	// 접근제어 session객체는 서버가 보관
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO member, Model model, HttpSession session) { // form 객체 name="" 값이 MemberVO와 일치하면
																					// 자동으로 주입됨.
		member = memberDao.memberSelect(member);
		if (member != null) {
			session.setAttribute("id", member.getId()); // 세션에 아이디값 담는다.
			session.setAttribute("author", member.getAuthor()); // 세션에 권한을 담는다.
			model.addAttribute("message", member.getName() + "님 환영합니다.");

		} else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}
		return "member/memberLogin";// jsp 만들러 ㄱㄱ
	}

	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
			//session을 없애버리면 Logout이 됨
			session.invalidate();	// session을 서버에서 삭제한다.
			model.addAttribute("message", "로그아웃이 정상적으로 처리 되었습니다.");
			
		return "member/memberLogout"; //jsp 만들러 ㄱㄱ
		
	}
	
	@PostMapping("/ajaxSearchMember.do")
	@ResponseBody //ajax 호출한쪽으로 돌려줘라  
	public List<MemberVO> ajaxSearchMember(@RequestParam("key") String key, @RequestParam("data") String data){
		return memberDao.memberSearch(key, data); 
	}
	
	@RequestMapping("/memberJoinForm.do") //회원가입 폼 호출
	public String memberJoinFrom() {
		return "member/memberJoinForm";
	}

	@PostMapping("/memberJoin.do") //회원가입 //id가 file이란 애를  MultipartFile이란 객체에 file에다 담겠다 //나머지애들은 MeberVO객체에 담김 
	public String memberJoin(@RequestParam("file")MultipartFile file, MemberVO member, Model model) {
		int n = memberDao.memberInsert(member);
		if(n != 0) {
			model.addAttribute("message","회원가입이 성공 되었습니다");
			
		}else {
			model.addAttribute("message","회원가입이 실패 했습니다.");
		}
		
		return "member/memberJoin";
	}
	
	@PostMapping("/ajaxIsidCheck.do") //아이디 중복체크
	@ResponseBody
	public boolean ajaxIsidCheck(String id) {
		boolean b = memberDao.isIdCheck(id);
		return b;
	}
}
