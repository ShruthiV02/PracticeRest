package com.restapi.assignment.findingnumber.response;

import java.util.Map;

public class ResponseHolder {

	private String fragment;

	private Map<String, String> numberDetails;

	private int numberOfWordsInTheText;

	// Default Constructor
	public ResponseHolder() {
	}

	// FieldConstructor
	public ResponseHolder(String fragment, Map<String, String> numberDetails, int numberOfWordsInTheText) {
		super();
		this.fragment = fragment;
		this.numberDetails = numberDetails;
		this.numberOfWordsInTheText = numberOfWordsInTheText;
	}

	public String getFragment() {
		return fragment;
	}

	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	public Map<String, String> getNumberDetails() {
		return numberDetails;
	}

	public void setNumberDetails(Map<String, String> numberDetails) {
		this.numberDetails = numberDetails;
	}

	public int getNumberOfWordsInTheText() {
		return numberOfWordsInTheText;
	}

	public void setNumberOfWordsInTheText(int numberOfWordsInTheText) {
		this.numberOfWordsInTheText = numberOfWordsInTheText;
	}

}
