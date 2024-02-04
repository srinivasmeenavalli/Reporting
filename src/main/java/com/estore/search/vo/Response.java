package com.estore.search.vo;

import java.util.List;

/**
 * Value Object to hold Response from search engine.
 * 
 * 
 * 
 */
public class Response {
	/** records */
	private List<Record> mRecords;
	
	/** facets */
	private List<Facet> mFacets;
	
	/** List of bread Crumbs */
	private List<BreadCrumbVO> mBreadCrumbs;
	
	/**sortOptions List */
	private List<SortOption> mSortOptions;
	
	/**pageViews List */
	private List<PageView> mPageViews;
	
	/**begin  */
	private Integer mBegin = 1;
	
	/** documents Num Found */
	private Integer mDocumentNumFound;
	
	/**pagination views Per Page  */
	private Integer mPaginationPerPage = 5;
	
	/**end */
	private Integer mEnd = 1;
	
	/**pageCreation */
	private Integer mPageCreation;
	
	/**selectedPageView */
	private Integer mSelectedPageView;
	
	/**searchTerm */
	private String mSearchTerm;
	
	/**selectedSort */
	private Integer mSelectedSort;
	
	/**selectedPageNO */
	private Integer mSelectedPageNO;
	
	/**selectedPageNO */
	private List<SuggestionVO> mSuggestionList ;
	
	public List<SuggestionVO> getSuggestionList() {
		return mSuggestionList;
	}

	public void setSuggestionList(List<SuggestionVO> pSuggestionList) {
		this.mSuggestionList = pSuggestionList;
	}

	/**
	 * returns Selected Page Number
	 * @return Integer Selected Page Number
	 */
	public Integer getSelectedPageNO() {
		return mSelectedPageNO;
	}
	
	/**
	 * sets Selected Page Number 
	 * @param pSelectedPageNO
	 */
	public void setSelectedPageNO(Integer pSelectedPageNO) {
		this.mSelectedPageNO = pSelectedPageNO;
	}
	/**
	 * returns Selected Sort
	 * @return Integer Selected Sort
	 */
	public Integer getSelectedSort() {
		return mSelectedSort;
	}
	/**
	 * sets Selected Sort
	 * @param pSelectedSort
	 */
	public void setSelectedSort(Integer pSelectedSort) {
		this.mSelectedSort = pSelectedSort;
	}
	/**
	 * returns SearchTerm
	 * @return String SearchTerm
	 */
	public String getSearchTerm() {
		return mSearchTerm;
	}
	/**
	 * sets Search Term
	 * @param pSearchTerm
	 */
	public void setSearchTerm(String pSearchTerm) {
		this.mSearchTerm = pSearchTerm;
	}
	/**
	 * returns Records
	 * @return List<Record> Records
	 */
	public List<Record> getRecords() {
		return mRecords;
	}
	/**
	 * sets Records
	 * @param pRecords
	 */
	public void setRecords(List<Record> pRecords) {
		this.mRecords = pRecords;
	}
	/**
	 * returns Facets
	 * @return List<Facet> Facets
	 */
	public List<Facet> getFacets() {
		return mFacets;
	}
	/**
	 * sets Facets
	 * @param pFacets
	 */
	public void setFacets(List<Facet> pFacets) {
		this.mFacets = pFacets;
	}
	/**
	 * returns Bread Crumbs
	 * @return List<BreadCrumbVO> Bread Crumbs
	 */
	public List<BreadCrumbVO> getBreadCrumbs() {
		return mBreadCrumbs;
	}
	/**
	 * returns Selected Page View
	 * @return Integer Selected Page View
	 */
	public Integer getSelectedPageView() {
		return mSelectedPageView;
	}
	/**
	 * sets Selected Page View
	 * @param pSelectedPageView
	 */
	public void setSelectedPageView(Integer pSelectedPageView) {
		this.mSelectedPageView = pSelectedPageView;
	}
	/**
	 * sets Bread Crumbs
	 * @param pBreadCrumbs
	 */
	public void setBreadCrumbs(List<BreadCrumbVO> pBreadCrumbs) {
		this.mBreadCrumbs = pBreadCrumbs;
	}
	/**
	 * returns Sort Options
	 * @return List<SortOption> Sort Options
	 */
	public List<SortOption> getSortOptions() {
		return mSortOptions;
	}
	/**
	 * sets Sort Options
	 * @param pSortOptions
	 */
	public void setSortOptions(List<SortOption> pSortOptions) {
		this.mSortOptions = pSortOptions;
	}
	/**
	 * returns Page Views
	 * @return List<PageView> Page Views
	 */
	public List<PageView> getPageViews() {
		return mPageViews;
	}
	/**
	 * sets Page Views
	 * @param pPageViews
	 */
	public void setPageViews(List<PageView> pPageViews) {
		this.mPageViews = pPageViews;
	}
	/**
	 * returns Page number to begin
	 * @return Integer Page number to begin
	 */
	public Integer getBegin() {
		return mBegin;
	}
	/**
	 * sets Page number to begin
	 * @param pBegin
	 */
	public void setBegin(Integer pBegin) {
		this.mBegin = pBegin;
	}
	/**
	 * returns count of search or browse  results
	 * @return Integer Integer  Document Num Found
	 */
	public Integer getDocumentNumFound() {
		return mDocumentNumFound;
	}
	/**
	 * sets count of search or browse  results
	 * @param pDocumentNumFound
	 */
	public void setDocumentNumFound(Integer pDocumentNumFound) {
		this.mDocumentNumFound = pDocumentNumFound;
	}
	/**
	 * returns Pagination Per Page
	 * @return Integer Pagination Per Page
	 */
	public Integer getPaginationPerPage() {
		return mPaginationPerPage;
	}
	/**
	 * sets Pagination Per Page
	 * @param pPaginationPerPage
	 */
	public void setPaginationPerPage(Integer pPaginationPerPage) {
		this.mPaginationPerPage = pPaginationPerPage;
	}
	/**
	 * returns End Page
	 * @return Integer End
	 */
	public Integer getEnd() {
		return mEnd;
	}
	/**
	 * sets end Page
	 * @param pEnd
	 */
	public void setEnd(Integer pEnd) {
		this.mEnd = pEnd;
	}
	/**
	 * returns PageCreation
	 * @return Integer getPageCreation
	 */
	public Integer getPageCreation() {
		return mPageCreation;
	}
	/**
	 * sets  Page Creation
	 * @param pPageCreation
	 */
	public void setPageCreation(Integer pPageCreation) {
		this.mPageCreation = pPageCreation;
	}

}
