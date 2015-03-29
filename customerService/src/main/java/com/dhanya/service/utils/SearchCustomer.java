package com.dhanya.service.utils;
/**
 * Model object for searching customer
 * @author Leela Gutta
 */

public class SearchCustomer {

	private SearchType searchType;

	private String searchValue;

	public SearchCustomer(SearchType searchType, String searchValue) {
		this.searchType = searchType;
		this.searchValue = searchValue;
	}

	public SearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}