package com.estore.search.service;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Service;

import com.estore.search.dao.SolrEStoreDAOImpl;
import com.estore.search.parser.SolrResultsParser;
import com.estore.search.query.SolrQueryBuilder;
import com.estore.search.vo.Request;
import com.estore.search.vo.Response;

/***
 * 
 * 
 * 
 */

@Service
public class SolrSearchService implements SearchService {
	
	/**
	 * Search Request
	 * @param pRequest - Request Object
	 */
	public Response search(Request pRequest) {

		System.out.println("#Enter SolrSearchService.search");

		SolrQueryBuilder queryBuilder = new SolrQueryBuilder();
		//Build Solr Query 
		SolrQuery solrQuery = (SolrQuery) queryBuilder.buildQuery(pRequest);

		SolrEStoreDAOImpl dao = new SolrEStoreDAOImpl();
		//Execute Solr Queru
		Object response = dao.executeQuery(solrQuery);

		if (response != null) {
			//System.out.println("Got the response in Service:" + response);
			System.out.println("Got the response in Service:");

		}
		//Parse Results and convert results into Generic Format.
		SolrResultsParser parser = new SolrResultsParser();
		Response parsedResponse = parser.parseResults(response);
		if (parsedResponse != null) {

			if (parsedResponse.getRecords() != null) {				
					System.out.println("Records found in Service:"
							+ parsedResponse.getRecords().size());				
			}
			else{
				System.out.println("No Records found in Service: Validate Your Query");		
				
			}

			if (parsedResponse.getFacets() != null) {
					System.out.println("Facets found in Service:"
							+ parsedResponse.getFacets().size());
			}
			else{
				System.out.println("No Facets found in Service: Validate Your Query");
	
			}
			

		}
		System.out.println("#Return/Exit SolrSearchService.search");
		return parsedResponse;
	}

}
