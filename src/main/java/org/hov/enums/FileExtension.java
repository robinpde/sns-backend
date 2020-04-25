package org.hov.enums;

public enum FileExtension {
	JPG(".jpg"),
	PNG(".png"),
	PDF(".pdf"),
	DOC(".doc"),
	DOCX(".docx"),
	UNKNOWN("");
	
	private String extension;
	
	FileExtension(String extension) {
		this.extension = extension;
	}
	
	public String getExtensionText() {
		return extension;
	}
}