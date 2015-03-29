package org.model.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * It is a class that is exposed and takes in values
 * @author Leela Gutta
 *
 */

public class SearchModel {

	@NotEmpty(message = "Please enter search type.")
	private String searchType;

	@NotEmpty(message = "Please enter search value")
	private String searchValue;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}