package com.estore.search.dao;

import java.io.IOException;


import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Component;

import com.estore.search.helper.EStoreHelper;

/**
 * 
 * @author Your First Name, Surname {eclipse.ini}
 * 
 */
@Component
public class SolrEStoreDAOImpl implements EStoreDAO {

	
	/***
	 * 
	 *  
	 */
	public Object executeQuery(Object query) {

		System.out.println("#Enter SolrEStoreDAOImpl.executeQuery");
		String cameraHost = EStoreHelper.getCameraStoreHost();
			System.out.println("#Printing CameraStore Host URL:" + cameraHost);
		
		HttpSolrClient solrClient = new HttpSolrClient(cameraHost);
		SolrQuery solrQuery = (SolrQuery) query;
		System.out.println("solrQuery    "+solrQuery);
		QueryResponse response = null;
		try {
				System.out.println("Printing SolrQuery:   " + solrQuery);
				System.out.println("Executing SolrQuery.....");
			
			response = solrClient.query(solrQuery);
			//System.out.println("Response    "+response);
			if (response != null) {
				
					System.out.println("Got Response from Solr, No of records found:" + response.getResults().getNumFound());
				
			}
		} catch (SolrServerException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				solrClient.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("#Return SolrEStoreDAOImpl.executeQuery ");
		return response;
	}

}
