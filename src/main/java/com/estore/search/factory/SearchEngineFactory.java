package com.estore.search.factory;

import org.springframework.stereotype.Component;

import com.estore.search.constants.EStoreConstants.SEARCH_ENGINE_TYPE;
import com.estore.search.dao.SolrEStoreDAOImpl;
import com.estore.search.service.SearchService;
import com.estore.search.service.SolrSearchService;

/**
 * 
 * @author Your First Name, Surname {eclipse.ini}
 * 
 */

@Component
public class SearchEngineFactory {
	private SEARCH_ENGINE_TYPE searchImplType = SEARCH_ENGINE_TYPE.SOLR;

	/**
	 * 
	 * @param searchImplType
	 * @return
	 */
	public SearchService getInstance() {
		
		System.out.println("#Enter SearchEngineFactory.getInstance");
		SearchService SearchService = null;
		switch (searchImplType) {
		case SOLR:
			SearchService = new SolrSearchService();
			System.out.println("Initialised SolrSearchService class");
			break;

		default:// Solr as default
			SearchService = new SolrSearchService();
			break;
		}
		System.out.println("#Return/Exit SearchEngineFactory.getInstance");
		return SearchService;

	}

}
