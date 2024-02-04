package com.estore.search.vo;

/**
 * Value Object for Bread crumbs
 * 
 * 
 * 
 */
public class BreadCrumbVO {
	/** bread Crumb Label */
	private String mBreadCrumbLabel;
	/** bread Crumb Value */
	private String mBreadCrumbValue;

	/**
	 * 
	 * @return String Bread Crumb Label
	 */
	public String getBreadCrumbLabel() {
		return mBreadCrumbLabel;
	}

	/**
	 * Setter method for Bread Crumb Label
	 * 
	 * @param pBreadCrumbLabel
	 */
	public void setBreadCrumbLabel(final String pBreadCrumbLabel) {
		this.mBreadCrumbLabel = pBreadCrumbLabel;
	}

	/**
	 * Getter method for Bread Crumb Value
	 * 
	 * @return String Bread Crumb Value
	 */
	public String getBreadCrumbValue() {
		return mBreadCrumbValue;
	}

	/**
	 * Setter Method for Bread Crumb Value
	 * 
	 * @param pBreadCrumbValue
	 *            - Bread Crumb Value
	 */
	public void setBreadCrumbValue(String pBreadCrumbValue) {
		this.mBreadCrumbValue = pBreadCrumbValue;
	}

}
