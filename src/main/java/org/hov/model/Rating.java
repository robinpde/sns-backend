package org.hov.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "rating")
public class Rating {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID ratingid;
	
	@Column(name = "rating_value")
	@Range(min = 1, max = 5, message = "SNSERR000006")							//Out of Range
	private int ratingValue;
	
	@Column(name="summary_text")
	private String summary;

	@Column(name="comment_text")
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rated_item")
	private Item ratedItem;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_user")
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "images_list")
	private List<MetaFile> imagesList = new ArrayList<>();
	
	public UUID getRatingid() {
		return ratingid;
	}

	public void setRatingid(UUID ratingid) {
		this.ratingid = ratingid;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Item getRatedItem() {
		return ratedItem;
	}

	public void setRatedItem(Item ratedItem) {
		this.ratedItem = ratedItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}

	/* IMAGES LIST HELPER FUNCTIONS */
	public List<MetaFile> getImagesList() {
		return imagesList;
	}
	
	public void addMetaFile(MetaFile file) {
		if(file != null) {
			this.getImagesList().add(file);
			file.setLinked(true);
		}
	}
	
	public void removeMetaFile(MetaFile file) {
		if(file != null) {
			this.getImagesList().remove(file);
			file.setLinked(false);
		}
	}
}