package com.explore.microservices.domain;

public enum Region {
	Central_Coast("Central Coast"),
	Southern_California("Southern California"),
	Northern_California("Northern California"),
	Varies("Varies");

	private String label;
	
	Region(String label) {
		this.label = label;
	}
	
	public static Region findByLabel(String region) {
		for(Region r : Region.values()) {
			if(r.label.equalsIgnoreCase(region)) {
				return r;
			}
		}
		return null;
	}
}
