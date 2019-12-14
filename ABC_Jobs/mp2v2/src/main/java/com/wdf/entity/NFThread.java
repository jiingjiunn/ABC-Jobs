package com.wdf.entity;

import java.util.List;

public class NFThread extends Entity{
	private String owner;
	private int ownerId;
	private String content;
	private List<NFThreadReply> replies;
	private String DateTime;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String string) {
		this.owner = string;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<NFThreadReply> getReplies() {
		return replies;
	}
	public void setReplies(List<NFThreadReply> replies) {
		this.replies = replies;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	@Override
	public String toString() {
		return "NFThread [owner=" + owner + ", ownerId=" + ownerId + ", content=" + content + ", replies=" + replies
				+ ", DateTime=" + DateTime + ", getOwner()=" + getOwner() + ", getContent()=" + getContent()
				+ ", getReplies()=" + getReplies() + ", getDateTime()=" + getDateTime() + ", getOwnerId()="
				+ getOwnerId() + ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
