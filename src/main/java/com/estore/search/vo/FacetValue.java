package com.estore.search.vo;

/**
 * Value Object to hold Facet Values
 * 
 * 
 */
public class FacetValue {
	
	/**Facet Name */
	private String mFacetName;
	
	/** Facet Label */
	private String mFacetLabel;
	
	/**Facet Count  */
	private String mFacetCount;

	/**
	 * returns Facet Name
	 * @return String FacetName
	 */
	public String getFacetName() {
		return mFacetName;
	}
	/**
	 * sets Facet Name
	 * @param pFacetName
	 */
	public void setFacetName(String pFacetName) {
		this.mFacetName = pFacetName;
	}
	/**
	 * returns Facet Label
	 * @return String Facet Label
	 */
	public String getFacetLabel() {
		return mFacetLabel;
	}
	/**
	 * sets Facet Label
	 * @param pFacetLabel
	 */
	public void setFacetLabel(String pFacetLabel) {
		this.mFacetLabel = pFacetLabel;
	}
	/**
	 * returns Facet Count
	 * @return String Facet Count
	 */
	public String getFacetCount() {
		return mFacetCount;
	}
	/**
	 * sets Facet Count
	 * @param pFacetCount
	 */
	public void setFacetCount(String pFacetCount) {
		this.mFacetCount = pFacetCount;
	}

}
