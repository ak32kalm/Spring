//�Խ��� DB ����� 1.

package co.micol.prj.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id; 
	private String writerId; //�ۼ��� ID
	private String writerName;
	private Date writerDate; // �ú��ʰ� �߿��ϴ� : java.util // ��¥�� ���� java.sql
	private String title;
	private String subject;
	private int hit;
	private String attache; //÷������ ��
}

//�������̽� ���鷯 ����