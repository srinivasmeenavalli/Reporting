package com.estore.search.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.estore.search.constants.EStoreConstants.PAGE_VIEWS;
import com.estore.search.constants.EStoreConstants.SERVICE_TYPES;
import com.estore.search.constants.EStoreConstants.SORT_OPTIONS;

/**
 * Value Object to hold Request parameters
 * 
 * 
 * 
 */
@Component
public class Request {

	/** Service Type */
	private SERVICE_TYPES mServiceType;

	/** search Term */
	private String mSearchTerm;

	/** maxSuggestions */
	private PAGE_VIEWS mMaxSuggestions;

	/** page Number */
	private int mPageNumber = 1;

	/** sortOption */
	private SORT_OPTIONS mSortOption;

	/** refinements */
	private List<RefinementRequest> mRefinements;

	/**
	 * returns SERVICE_TYPES
	 * 
	 * @return  SERVICE_TYPES Service Type
	 */
	public SERVICE_TYPES getServiceType() {
		return mServiceType;
	}

	/**
	 * sets Service Type
	 * 
	 * @param pSearch
	 */
	public void setServiceType(SERVICE_TYPES pSearch) {
		this.mServiceType = pSearch;
	}

	/**
	 * returns Search Term
	 * 
	 * @return String Search Term
	 */
	public String getSearchTerm() {
		return mSearchTerm;
	}

	/**
	 * sets Search Term
	 * 
	 * @param pSearchTerm
	 */
	public void setSearchTerm(String pSearchTerm) {
		this.mSearchTerm = pSearchTerm;
	}

	/**
	 * returns Max Suggestions
	 * 
	 * @return PAGE_VIEWS Max Suggestions
	 */
	public PAGE_VIEWS getMaxSuggestions() {
		return mMaxSuggestions;
	}

	/**
	 * sets Max Suggestions
	 * 
	 * @param pMaxSuggestions
	 */
	public void setMaxSuggestions(PAGE_VIEWS pMaxSuggestions) {
		this.mMaxSuggestions = pMaxSuggestions;
	}

	/**
	 * returns Page Number
	 * 
	 * @return int Page Number
	 */
	public int getPageNumber() {
		return mPageNumber;
	}

	/**
	 * sets pageNumber
	 * 
	 * @param pPageNumber
	 */
	public void setPageNumber(int pPageNumber) {
		this.mPageNumber = pPageNumber;
	}

	/**
	 * returns Sort Option
	 * 
	 * @return SORT_OPTIONS Sort Option
	 */

	public SORT_OPTIONS getSortOption() {
		return mSortOption;
	}

	/**
	 * sets Sort option Name
	 * 
	 * @param pSortoptionName
	 */
	public void setSortOption(SORT_OPTIONS pSortoptionName) {
		this.mSortOption = pSortoptionName;
	}

	/**
	 * returns List of Refinement Requests 
	 * 
	 * @return List<RefinementRequest> List of Refinement Requests
	 */
	public List<RefinementRequest> getRefinements() {
		return mRefinements;
	}

	/**
	 * sets Refinements
	 * 
	 * @param pRefinements
	 */
	public void setRefinements(List<RefinementRequest> pRefinements) {
		this.mRefinements = pRefinements;
	}

}
