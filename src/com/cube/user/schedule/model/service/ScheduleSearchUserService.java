package com.cube.user.schedule.model.service;

public interface ScheduleSearchUserService {
	String list();
	String search(String start, String end, String kind);
	void update(int seq, String subject, String content, String kind, String start, String end);
	void delete(int seq);
	String view(int seq);
}