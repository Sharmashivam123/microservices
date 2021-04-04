package com.explore.microservices.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class TourRating {

	@EmbeddedId
	private TourRatingPk tourRatingPk;
	
	@Column(nullable = false)
	private Integer score;
	
    @Column
    private String comment;
	
	public TourRating(TourRatingPk tourRatingPk, Integer score, String comment) {
		this.tourRatingPk = tourRatingPk;
		this.score = score;
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	protected TourRating() {}

	public TourRatingPk getTourRatingPk() {
		return tourRatingPk;
	}

	public void setTourRatingPk(TourRatingPk tourRatingPk) {
		this.tourRatingPk = tourRatingPk;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
