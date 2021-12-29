//2.
package co.micol.prj.notice.service;

import java.util.List;

public interface NoticeService {

	
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO notice);
	int noticeInsert(NoticeVO notice);
	int noticeDelete(NoticeVO notice);
	int noticeUpdate(NoticeVO notice);

	int noticeHitUpdate(int id); //��ȸ�� ����
	int noticeIdUpdate(int id); // ������ id�� ������� �ʰ� ������ ���� 12345 �� 3�� ������ 45�� 34��
	
	
	List<NoticeVO> noticeSearch(String key, String val); // ���� ����?, ���뿡 ����?
	
}

//mapper�������̽� ����
