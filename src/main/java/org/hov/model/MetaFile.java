package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hov.enums.FileExtension;

@Entity
@Table(name = "meta_file")
public class MetaFile {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID metaid;
	
	@Column(name="file_extension")
	@Enumerated(EnumType.ORDINAL)
	private FileExtension fileExtension;
	
	private boolean linked;

	public UUID getMetaid() {
		return metaid;
	}

	public void setMetaid(UUID metaid) {
		this.metaid = metaid;
	}

	public boolean isLinked() {
		return linked;
	}

	public void setLinked(boolean linked) {
		this.linked = linked;
	}

	public FileExtension getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(FileExtension fileExtension) {
		this.fileExtension = fileExtension;
	}
	
	public String getExtensionWithDot(FileExtension fileExtension) {
		return this.getFileExtension().getExtensionText();
	}
}