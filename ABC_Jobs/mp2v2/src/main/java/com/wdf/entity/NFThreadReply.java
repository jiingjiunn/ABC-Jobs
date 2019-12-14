package com.wdf.entity;

public class NFThreadReply extends Entity{
	private String ReplyContent;
	private int Owner;
	private String DateTime;
	private int ThreadId;
	
	
	public int getThreadId() {
		return ThreadId;
	}
	public void setThreadId(int threadId) {
		ThreadId = threadId;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	public String getReplyContent() {
		return ReplyContent;
	}
	public void setReplyContent(String replyContent) {
		ReplyContent = replyContent;
	}
	public int getOwner() {
		return Owner;
	}
	public void setOwner(int owner) {
		Owner = owner;
	}
	
	
}
