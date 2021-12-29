package co.micol.prj.member.service;

import lombok.Getter;
import lombok.Setter;
//si에서는 getter setter만 쓰면 됨
@Setter
@Getter
public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String author;
	private String tell;
	private String address;
	private String picture;
	private String pfile;
}
