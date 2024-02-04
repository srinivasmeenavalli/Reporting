package com.estore.search.vo;

/**
 * Value Object for Refinement Requests
 * 
 * 
 */
public class RefinementRequest {
	
	/** Refinement Name */
	private String mRefinementName;
	
	/** Refinement Value*/
	private String mRefinementValue;
	
	/**
	 * Returns Refinement Name
	 * @return String Refinement Name
	 */
	public String getRefinementName() {
		return mRefinementName;
	}
	
	/**
	 * Sets Refinement Name
	 * @param pRefinementName
	 */
	public void setRefinementName(String pRefinementName) {
		this.mRefinementName = pRefinementName;
	}
	/**
	 * returns Refinement Value
	 * @return String RefinementValue
	 */
	public String getRefinementValue() {
		return mRefinementValue;
	}
	/**
	 * Sets Refinement Value 
	 * @param pRefinementValue
	 */
	public void setRefinementValue(String pRefinementValue) {
		this.mRefinementValue = pRefinementValue;
	}

}
