package com.estore.search.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estore.search.constants.EStoreConstants;
import com.estore.search.constants.EStoreConstants.PAGE_VIEWS;
import com.estore.search.constants.EStoreConstants.SEARCH_ENGINE_TYPE;
import com.estore.search.constants.EStoreConstants.SERVICE_TYPES;
import com.estore.search.constants.EStoreConstants.SORT_OPTIONS;
import com.estore.search.factory.SearchEngineFactory;
import com.estore.search.service.SearchService;
import com.estore.search.vo.BreadCrumbVO;
import com.estore.search.vo.Record;
import com.estore.search.vo.RefinementRequest;
import com.estore.search.vo.Request;
import com.estore.search.vo.Response;

/**
 * 
 * 
 * 
 */
@Controller
public class EStoreController {

	

	@Autowired
	/**factory Instance **/
	SearchEngineFactory factory;
	@Autowired
	/** Search Service */
	SearchService searchService;

	/**
	 * Handles browse URL's
	 * 
	 * @param pModel
	 *            - Model Object
	 * @param pRequest
	 *            - Request Object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/browse", "/" })
	private String handleBrowse(ModelMap pModel, HttpServletRequest pRequest) {
		System.out.println("#Enter EStoreController.handleBrowse");

		Map<String, String[]> parameterValues = pRequest.getParameterMap();
		Request requestVO = null;
		if (parameterValues != null) {
			requestVO = new Request();
				if (parameterValues != null) {
					System.out.println("Request Paramameter Map:" + parameterValues);
				}
			
			//search Term
			String[] searchTerm = parameterValues
					.get(EStoreConstants.SEARCH_TERM);

			if (searchTerm != null) {
				requestVO.setSearchTerm(searchTerm[EStoreConstants.INTEGER_0]);
					if (searchTerm != null) {
						System.out.println("Entered Search Term:"
								+ searchTerm[EStoreConstants.INTEGER_0]);
					}
				

			}
			//Page View
			String[] page = parameterValues.get(EStoreConstants.PAGE);
			if (page != null) {
				requestVO.setPageNumber(Integer
						.parseInt(page[EStoreConstants.INTEGER_0]));
			}
			String[] record = parameterValues.get(EStoreConstants.RECORD);
			if (record != null) {
				if (Integer.parseInt(record[EStoreConstants.INTEGER_0]) == EStoreConstants.INTEGER_24) {
					requestVO.setMaxSuggestions(PAGE_VIEWS.VIEW_24);
				} else if (Integer.parseInt(record[EStoreConstants.INTEGER_0]) == EStoreConstants.INTEGER_36) {
					requestVO.setMaxSuggestions(PAGE_VIEWS.VIEW_36);
				} else if (Integer.parseInt(record[EStoreConstants.INTEGER_0]) == EStoreConstants.INTEGER_48) {
					requestVO.setMaxSuggestions(PAGE_VIEWS.VIEW_48);
				} else if (Integer.parseInt(record[EStoreConstants.INTEGER_0]) == EStoreConstants.INTEGER_60) {
					requestVO.setMaxSuggestions(PAGE_VIEWS.VIEW_60);
				} else {
					requestVO.setMaxSuggestions(PAGE_VIEWS.VIEW_12);
				}
			}
			//Facets for Refinements 
			String[] facetField = parameterValues
					.get(EStoreConstants.FACET_FIELD);
			String[] facetValue = parameterValues
					.get(EStoreConstants.FACET_VALUE);
			populateRefinementList(facetField, facetValue);
			List<RefinementRequest> refinementList = populateRefinementList(
					facetField, facetValue);
			if (refinementList != null
					&& refinementList.size() > EStoreConstants.INTEGER_0) {
					System.out.println("RefinementList Size:" + refinementList.size());
				
				requestVO.setRefinements(refinementList);
			}
			//Sort options
			String[] sortList = parameterValues.get(EStoreConstants.SORT);
			if (sortList != null) {
				String sort = sortList[EStoreConstants.INTEGER_0];
				if (sort.length() > EStoreConstants.INTEGER_0) {
					if (sort.equals(EStoreConstants.ONE)) {
						requestVO.setSortOption(SORT_OPTIONS.ASCENDING);

					} else if (sort.equals(EStoreConstants.TWO)) {
						requestVO.setSortOption(SORT_OPTIONS.DESCENDING);
					} else if (sort.equals(EStoreConstants.THREE)) {
						requestVO.setSortOption(SORT_OPTIONS.RELEVANCE);

					}

				}
			}
		} else {
				System.out.println("Request Paramameter Map is Null:");

			
		}

		Response response = null;
		//Call Search Engine
		searchService = factory.getInstance();

		if (searchService != null && requestVO != null) {

			response = searchService.search(requestVO);
			if (response != null) {
				List<BreadCrumbVO> breadCrumList = response.getBreadCrumbs();

				StringBuilder breadCrumbLabel = null;
				StringBuilder breadCrumbValue = null;
				if (breadCrumList != null && !breadCrumList.isEmpty()) {
					final int breadCrumSize = breadCrumList.size();
					breadCrumbLabel = new StringBuilder();
					breadCrumbValue = new StringBuilder();
					for (int i = EStoreConstants.INTEGER_0; i < breadCrumSize; i++) {

						breadCrumbLabel.append(breadCrumList.get(i)
								.getBreadCrumbLabel() + "#");
						breadCrumbValue.append(breadCrumList.get(i)
								.getBreadCrumbValue() + "#");

					}
				}
				//Set model Objects
				setModelValues(pModel, response, breadCrumbLabel,
						breadCrumbValue);
			}

		}

		System.out.println("#Return/Exit EStoreController.handleBrowse");
		return "store";
	}

	/**
	 * Populates Refinements List
	 * 
	 * @param pFacetField
	 *            -Facet Field
	 * @param pFacetValue
	 *            - Facet Value
	 * @return List<RefinementRequest> - List of Refinement Requests
	 */
	private List<RefinementRequest> populateRefinementList(String[] pFacetField,
			String[] pFacetValue) {

		List<RefinementRequest> lRefinementList = new ArrayList<RefinementRequest>();
		if (pFacetField != null && pFacetValue != null) {
			final int fieldLength = pFacetField.length;
			final int valueLength = pFacetValue.length;
			for (int i = EStoreConstants.INTEGER_0; i < fieldLength
					&& i < valueLength; i++) {
				RefinementRequest lRefinementRequest = new RefinementRequest();
				//Set Facet Name
				lRefinementRequest.setRefinementName(pFacetField[i]);
				//Set Facet Value
				lRefinementRequest.setRefinementValue(pFacetValue[i]);
				lRefinementList.add(lRefinementRequest);
			}
		}
		return lRefinementList;
	}

	/**
	 * Set Model Object Values
	 * 
	 * @param model
	 *            - Model Object
	 * @param response
	 *            - Response
	 * @param breadCrumbLabel
	 * @param breadCrumbValue
	 */
	private void setModelValues(ModelMap pModel, Response pResponse,
			StringBuilder pBreadCrumbLabel, StringBuilder pBreadCrumbValue) {
		pModel.put(EStoreConstants.RECORDS, pResponse.getRecords());// Records
		pModel.put(EStoreConstants.FACETS, pResponse.getFacets());// Facets
		pModel.put(EStoreConstants.BEGIN, pResponse.getBegin());// Start
		pModel.put(EStoreConstants.END, pResponse.getEnd());// End
		pModel.put(EStoreConstants.SEARCH, pResponse.getSearchTerm());// Search
																		// Term
		pModel.put(EStoreConstants.PAGINATION_PER_PAGE,// Pagination
				pResponse.getPaginationPerPage());
		pModel.put(EStoreConstants.DOCUMENT_NUM_FOUND,
				pResponse.getDocumentNumFound());// TotlRecords
		pModel.put(EStoreConstants.PAGE_CREATION, pResponse.getPageCreation());
		pModel.put(EStoreConstants.SELECTED_PAGE_VIEW,
				pResponse.getSelectedPageView());// Selected Page View
		pModel.addAttribute(EStoreConstants.PAGE_VIEWS,
				pResponse.getPageViews());// Page Views
		pModel.addAttribute(EStoreConstants.BREADCRUM_VALUE, pBreadCrumbValue);// Bread
																				// crumb
																				// Value
		pModel.addAttribute(EStoreConstants.BREADCRUM_LABEL, pBreadCrumbLabel);// Bread
																				// crumb
																				// label
		pModel.addAttribute(EStoreConstants.SELECTIONS,
				pResponse.getBreadCrumbs());
		pModel.addAttribute(EStoreConstants.SORTOPTIONS,
				pResponse.getSortOptions());// Sort options
		pModel.addAttribute(EStoreConstants.SELECTED_SORT_OPTION,
				pResponse.getSelectedSort());// Selected Sort Option
		pModel.put(EStoreConstants.SELECTED_PAGE_NO,
				pResponse.getSelectedPageNO());// Selected Page Number
		pModel.put(EStoreConstants.SUGGEATIONS, pResponse.getSuggestionList());
	}

	@RequestMapping(value = "/productDetails/{pProductId}")
	/**
	 * handles Product
	 * @param model - Model Object 
	 * @param productId - Product Id 
	 * @return String 
	 */
	private String handleProduct(ModelMap pModel,
			@PathVariable String pProductId) {
		Request requestVO = new Request();
		String searchTerm = "id:" + pProductId;
			System.out.println("Search Term in handleProduct   " + searchTerm);
		
		// Set Search term,Count,Service Type
		requestVO.setSearchTerm(searchTerm);
		requestVO.setMaxSuggestions(PAGE_VIEWS.VIEW_1);
		requestVO.setServiceType(SERVICE_TYPES.PDP);
		searchService = factory.getInstance();
		// Call Service
		Response response = searchService.search(requestVO);
		List<Record> records = response.getRecords();
		if (records != null) {
			pModel.put("records", records);
				System.out.println(records.size() + " Records found  # ");
		} else {
				System.out.println("No Records Found for Search Term # " + searchTerm);
		}
		return "productDetails";
	}
}
