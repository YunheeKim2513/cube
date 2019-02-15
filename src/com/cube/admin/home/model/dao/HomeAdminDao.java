package com.cube.admin.home.model.dao;

import java.util.List;

import com.cube.model.dto.MemoDto;
import com.cube.model.dto.NoticeDto;

public interface HomeAdminDao {
	void noticwriter(NoticeDto noticeDto);
	int noticeseq(String employee_id);
	NoticeDto noticeview(int seq);
	List<NoticeDto> noList();
	List<MemoDto> memoList(int seq);
	void memoWrite(MemoDto memoDto);
	void memoDelete(int mseq);
	void memoModify(MemoDto memoDto);
	void noticeUpdate(NoticeDto noticeDto);
	void noticeComplite(int seq);
}
