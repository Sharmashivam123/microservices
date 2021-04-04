package com.explore.microservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class TourRatingPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Tour tour;
	
	@Column(nullable = false, insertable = false, updatable = false)
	private Integer customerId;

	public TourRatingPk(Tour tour, Integer customerId) {
		super();
		this.tour = tour;
		this.customerId = customerId;
	}

	public TourRatingPk() {
		
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
	
}
