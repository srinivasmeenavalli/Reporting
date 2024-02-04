package com.estore.search.vo;

import java.util.List;

/**
 * Value Object for Facets
 * 
 * @author SMeenavali
 * 
 */
public class Facet {

	/** Facet Name */
	private String mFacetName;

	/** Facet Values List */
	private List<FacetValue> mFacetValues;

	/** Flag to identify multi-Select or Not */
	private boolean mIsMultiSelect;

	/**
	 * Returns Facet Name
	 * 
	 * @return String Facet Name
	 */
	public String getFacetName() {
		return mFacetName;
	}

	/**
	 * sets Facet name
	 * 
	 * @param pFacetName
	 */
	public void setFacetName(String pFacetName) {
		this.mFacetName = pFacetName;
	}

	/**
	 * Returns Facet Values
	 * @return List<FacetValue> Facet Values
	 */
	public List<FacetValue> getFacetValues() {
		return mFacetValues;
	}

	/**
	 * Sets facetValues
	 * @param pFacetValues
	 */
	public void setFacetValues(List<FacetValue> pFacetValues) {
		this.mFacetValues = pFacetValues;
	}

	/**
	 * isMultiSelect or not 
	 * @return boolean isMultiSelect or not
	 */
	public boolean isMultiSelect() {
		return mIsMultiSelect;
	}

	/**
	 * sets IsMultiSelect
	 * @param pIsMultiSelect
	 */
	public void setMultiSelect(boolean pIsMultiSelect) {
		this.mIsMultiSelect = pIsMultiSelect;
	}

}
