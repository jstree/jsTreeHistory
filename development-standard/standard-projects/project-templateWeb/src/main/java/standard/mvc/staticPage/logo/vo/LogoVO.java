package standard.mvc.staticPage.logo.vo;

import java.io.Serializable;

public class LogoVO implements Serializable {

	/**
	 * LogoVO - 로고파일 조정인데 어짜피 지울것 같지만 대충 만들어만 본다.
	 */
	private static final long serialVersionUID = -3125129327299296727L;
	
	private String fileName;
	private String filePath;
	private String fileType;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
