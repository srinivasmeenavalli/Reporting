package com.estore.search.vo;

import com.estore.search.constants.EStoreConstants.PAGE_VIEWS;

/**
 * Page view Value Object
 * 
 * 
 * 
 */
public class PageView {

	/** Page View Label */
	private String mPageViewLabel;

	/** Page View Value */
	private PAGE_VIEWS mPageViewValue;

	/**
	 * returns PageViewLabel
	 * 
	 * @return String Page View Label
	 */
	public String getPageViewLabel() {
		return mPageViewLabel;
	}

	/**
	 * sets Page View Label
	 * 
	 * @param pPageViewLabel
	 */
	public void setPageViewLabel(String pPageViewLabel) {
		this.mPageViewLabel = pPageViewLabel;

	}

	/**
	 * returns PAGE_VIEWS
	 * 
	 * @return PAGE_VIEWS PageViewValue
	 */
	public PAGE_VIEWS getPageViewValue() {
		return mPageViewValue;
	}

	/**
	 * sets Page View Value
	 * 
	 * @param pPageViewValue
	 */
	public void setPageViewValue(PAGE_VIEWS pPageViewValue) {
		this.mPageViewValue = pPageViewValue;
	}

}
