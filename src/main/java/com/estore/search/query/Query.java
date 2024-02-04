package com.estore.search.query;

import com.estore.search.vo.Request;

public interface Query {
	public Object buildQuery(Request request);
}
