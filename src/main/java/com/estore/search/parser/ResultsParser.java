package com.estore.search.parser;

import com.estore.search.vo.Response;

public interface ResultsParser {
	public Response parseResults(Object response);
}
