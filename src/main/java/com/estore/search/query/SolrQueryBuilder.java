package com.estore.search.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;

import org.springframework.stereotype.Component;

import com.estore.search.constants.EStoreConstants;
import com.estore.search.constants.EStoreConstants.SERVICE_TYPES;
import com.estore.search.constants.EStoreConstants.SORT_OPTIONS;
import com.estore.search.vo.Exclude;
import com.estore.search.vo.Navigation;
import com.estore.search.vo.RefinementRequest;
import com.estore.search.vo.Request;
import com.estore.search.vo.Seach;

@Component
public class SolrQueryBuilder implements Query {
	public Object buildQuery(Request request) {
		SolrQuery solrQuery = new SolrQuery();
		String searchQuery = "";
		// start Json
		try {

			// navigation start
			Navigation navigation = new Navigation();
			List<String> navigationValue = new ArrayList<>();
			navigationValue.add("sourceID");
			navigationValue.add("sendingCountry");
			navigationValue.add("responseType");
			navigationValue.add("status");
			navigationValue.add("errorCode");
			navigation.setNavigation(navigationValue);
			Collection<Object> navigationFacts = new ArrayList<>();
			navigationFacts.add(navigation);
			for (Object fact : navigationFacts) {
				if (fact instanceof Navigation && request.getServiceType() != SERVICE_TYPES.PDP) {
					System.out.println("Navigation    " + ((Navigation) fact).getNavigation());
					List<String> navigationField = ((Navigation) fact).getNavigation();

					String[] finalFacetField = new String[navigationField.size()];
					finalFacetField = navigationField.toArray(finalFacetField);
					solrQuery.addFacetField(finalFacetField);
					solrQuery.setFacetMinCount(1);
					if (request.getSortOption() != null) {
						if (request.getSortOption() == SORT_OPTIONS.ASCENDING) {
							solrQuery.setSort("responseType", ORDER.asc);
						} else if (request.getSortOption() == SORT_OPTIONS.DESCENDING) {
							solrQuery.setSort("sendingCountry", ORDER.desc);
						} else if (request.getSortOption() == SORT_OPTIONS.RELEVANCE) {
							solrQuery.set("fl", "*, score");
						} else {
							solrQuery.set("fl", "*, score");
						}
					} else {
						solrQuery.set("fl", "*, score");
					}
					List<RefinementRequest> lRefinementList = request.getRefinements();
					if (lRefinementList != null && lRefinementList.size() > EStoreConstants.INTEGER_0) {
						String filterQuery = null;
						for (RefinementRequest refinementRequest : lRefinementList) {
							filterQuery = refinementRequest.getRefinementName() + EStoreConstants.FULL_COLON
									+ refinementRequest.getRefinementValue();
							System.out.println("filterQuery     " + filterQuery);
							solrQuery.addFilterQuery(filterQuery);
						}
					}
				}
			}
			// search start
			Seach search = new Seach();
			List<String> searchFieldRule = new ArrayList<String>();
			searchFieldRule.add("_text_");
			search.setSearch(searchFieldRule);
			Collection<Object> searchFacts = new ArrayList<Object>();
			searchFacts.add(search);
			for (Object fact : searchFacts) {
				if (fact instanceof Seach && (request.getSearchTerm() != null)
						&& (!request.getSearchTerm().isEmpty())) {
					System.out.println("Seach    " + ((Seach) fact).getSearch());
					List<String> searchField = ((Seach) fact).getSearch();
					int count = 0;
					for (String field : searchField) {
						count++;
						searchQuery = searchQuery + field + ":" + request.getSearchTerm();
						if (count < searchField.size()) {
							searchQuery = searchQuery + " OR ";
						}
					}
					if (searchQuery.contains(" OR ")) {
						searchQuery = "(" + searchQuery + ")";
					}
				}
			}
			// exclude start
			/*Exclude exclude = new Exclude();
			List<String> excludeValueRule = new ArrayList<>();
			excludeValueRule.add("product.category_id: 575");
			exclude.setExclude(excludeValueRule);

			Collection<Object> excludeFacts = new ArrayList<>();
			excludeFacts.add(exclude);
			for (Object fact : excludeFacts) {
				if (fact instanceof Exclude && (request.getSearchTerm() != null)
						&& (!request.getSearchTerm().isEmpty())) {
					System.out.println("Exclude   " + ((Exclude) fact).getExclude());
					List<String> excludeValue = ((Exclude) fact).getExclude();
					String excludeQuery = "";
					for (String value : excludeValue) {
						excludeQuery = excludeQuery + " -" + value;
					}
					if (!excludeQuery.isEmpty()) {
						System.out.println("excludeQuery   " + excludeQuery);
						searchQuery = "(" + searchQuery + excludeQuery + ")";
					}
				}
			}
			*/
			if (!searchQuery.isEmpty()) {
				solrQuery.setParam("searchterm", request.getSearchTerm());
				solrQuery.setQuery(searchQuery);
				System.out.println("search Query    " + searchQuery);
			} else {
				solrQuery.set("q.alt", "*:*");
			}
			if (request.getMaxSuggestions() != null) {
				solrQuery.setStart(
						(request.getPageNumber() - EStoreConstants.INTEGER_1) * (request.getMaxSuggestions().getId()));
				solrQuery.setRows(request.getMaxSuggestions().getId());
			} else {
				solrQuery.setStart(EStoreConstants.INTEGER_0);
				solrQuery.setRows(EStoreConstants.INTEGER_12);
			}
			solrQuery.set("defType", "edismax");
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return solrQuery;
	}
	// end Json

}
