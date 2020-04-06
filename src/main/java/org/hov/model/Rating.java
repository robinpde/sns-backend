package org.hov.model;

import java.net.URL;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "ratings")
public class Rating {
	@Id
	@GeneratedValue
	private UUID ratingId;
	
	//@NotNull
	//private Item item;
	
	//@Column
	//private User user;
	
	@Column
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	@Range(min = 1, max = 5, message = "SNSERR000006")							//Out of Range
	private int value;
	private String title;
	private String comment;
	private URL image1;
	private URL image2;
	private URL image3;
	
	public UUID getRatingId() {
		return ratingId;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public URL getImage1() {
		return image1;
	}
	
	public void setImage1(URL image1) {
		this.image1 = image1;
	}
	
	public URL getImage2() {
		return image2;
	}
	
	public void setImage2(URL image2) {
		this.image2 = image2;
	}
	
	public URL getImage3() {
		return image3;
	}
	
	public void setImage3(URL image3) {
		this.image3 = image3;
	}
}