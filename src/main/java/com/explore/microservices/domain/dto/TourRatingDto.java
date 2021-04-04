package com.explore.microservices.domain.dto;

import com.explore.microservices.domain.TourRating;

public class TourRatingDto {

	private Integer score;
	private String comment;
	private Integer customerId;
	
	public TourRatingDto(TourRating tourRating) {
		this(tourRating.getScore(), tourRating.getComment(), tourRating.getTourRatingPk().getCustomerId());
	}
	
	public TourRatingDto(Integer score, String comment, int customerId) {
		this.score = score;
		this.comment = comment;
		this.customerId = customerId;
	}

	public TourRatingDto() {
		
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
}
