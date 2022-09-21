package com.demoweb.dto;

public class BoardAttachDto {
	
	private int attachNo;			// 첨부파일 고유 번호 (자동증가)
	private int boardNo;			// 첨부파일이 포함된 글번호 (참조)
	private String userFileName;	// 사용자가 업로드한 파일 이름
	private String savedFileName;	// 시스템에 저장된 파일 이름
	private int downloadCount;
	
	public int getAttachNo() {
		return attachNo;
	}
	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getUserFileName() {
		return userFileName;
	}
	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	

}
