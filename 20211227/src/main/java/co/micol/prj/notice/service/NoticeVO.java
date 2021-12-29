//게시판 DB 만들고 1.

package co.micol.prj.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id; 
	private String writerId; //작성자 ID
	private String writerName;
	private Date writerDate; // 시분초가 중요하다 : java.util // 날짜만 관리 java.sql
	private String title;
	private String subject;
	private int hit;
	private String attache; //첨부파일 명
}

//인터페이스 만들러 ㄱㄱ