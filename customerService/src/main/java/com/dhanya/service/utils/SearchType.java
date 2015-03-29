package com.dhanya.service.utils;

/**
 * Various search types that can be performed by the client.
 * 
 * @author Leela Gutta
 */
public enum SearchType {

	FIRSTNAME("firstName"), LASTNAME("lastName"), EMAIL("email"), PHONE("phone");

	private String type;

	SearchType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static SearchType fromString(String searchType) {
		if (searchType != null) {
			for (SearchType searcType : SearchType.values()) {
				if ((searcType.getType()).equalsIgnoreCase(searchType)) {
					return searcType;
				}
			}
		}
		return null;
	}
}