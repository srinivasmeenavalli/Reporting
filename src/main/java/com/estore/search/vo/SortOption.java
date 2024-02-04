package com.estore.search.vo;

import com.estore.search.constants.EStoreConstants.SORT_OPTIONS;

/**
 * Value Object to maintain Sort Options 
 * 
 *
 */
public class SortOption {
	
	/**Sort Option Label  */ 
	private String mSortOptionLabel;
	
	/**Sort Option Value */
	private SORT_OPTIONS mSortOptionValue;
	
	/**
	 * gets Sort Option Label 
	 * @return String mSortOptionLabel 
	 */
	public String getSortOptionLabel() {
		return mSortOptionLabel;
	}
	/**
	 * sets Sort Option Label
	 * @param sortOptionLabel
	 */
	public void setSortOptionLabel(String pSortOptionLabel) {
		this.mSortOptionLabel = pSortOptionLabel;
	}
	/**
	 * gets Sort Option Value 
	 * @return SORT_OPTIONS Sort Option Value 
	 */
	public SORT_OPTIONS getSortOptionValue() {
		return mSortOptionValue;
	}
	/**
	 * sest sort Option Value
	 * @param sortOptionValue
	 */
	public void setSortOptionValue(SORT_OPTIONS pSortOptionValue) {
		this.mSortOptionValue = pSortOptionValue;
	}

}
