package com.estore.search.service;

import com.estore.search.vo.Request;
import com.estore.search.vo.Response;

/**
 * Search Service Interface
 * 
 *
 */
public interface SearchService {
	
	
	/**
	 * 
	 * @param pRequest
	 * @return Response Response Object
	 */
	public Response search(Request pRequest);

}
