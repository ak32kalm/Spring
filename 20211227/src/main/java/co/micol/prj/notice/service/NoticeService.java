//2.
package co.micol.prj.notice.service;

import java.util.List;

public interface NoticeService {

	
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO notice);
	int noticeInsert(NoticeVO notice);
	int noticeDelete(NoticeVO notice);
	int noticeUpdate(NoticeVO notice);

	int noticeHitUpdate(int id); //조회수 증가
	int noticeIdUpdate(int id); // 삭제시 id를 비어있지 않게 순번을 변경 12345 중 3번 삭제시 45를 34로
	
	
	List<NoticeVO> noticeSearch(String key, String val); // 제목에 뭐가?, 내용에 뭐가?
	
}

//mapper인터페이스 ㄱㄱ
