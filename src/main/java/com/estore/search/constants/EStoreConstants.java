package com.estore.search.constants;

/**
 * 
 * 
 * 
 */
public class EStoreConstants {

	public final static Integer FACET_RANGE_GAP = 500;
	public final static String SEARCH_TERM = "searchTerm";
	public final static String PAGE = "page";
	public final static String RECORD = "record";
	public final static String SORT = "sort";
	public final static String FACET_FIELD = "facetField";
	public final static String FACET_VALUE = "facetValue";
	public final static int INTEGER_12 = 12;
	public final static int INTEGER_24 = 24;
	public final static int INTEGER_36 = 36;
	public final static int INTEGER_48 = 48;
	public final static int INTEGER_60 = 60;
	public final static Integer INTEGER_0 = 0;
	public final static Integer INTEGER_1 = 1;
	public final static Integer INTEGER_2 = 2;
	public final static Integer INTEGER_3 = 3;
	public final static Integer INTEGER_4 = 4;
	public final static Integer INTEGER_5000 = 5000;
	public final static String ONE = "1";
	public final static String TWO = "2";
	public final static String THREE = "3";
	public final static String RECORDS = "records";
	public final static String FACETS = "facets";
	public final static String BEGIN = "begin";
	public final static String END = "end";
	public final static String SEARCH = "search";
	public final static String PAGINATION_PER_PAGE = "paginationPerPage";
	public final static String DOCUMENT_NUM_FOUND = "documentNumFound";
	public final static String PAGE_CREATION = "pageCreation";
	public final static String SELECTED_PAGE_VIEW = "selectedPageView";
	public final static String PAGE_VIEWS = "pageViews";
	public final static String BREADCRUM_VALUE = "breadCrumbValue";
	public final static String BREADCRUM_LABEL = "breadCrumbLabel";
	public final static String SELECTIONS = "selections";
	public final static String SORTOPTIONS = "sortOptions";
	public final static String SELECTED_SORT_OPTION = "selectedsortOption";
	public final static String SELECTED_PAGE_NO = "selectedPageNO";
	public final static String FULL_COLON = ":";
	public final static String START_BRACKET = "[ ";
	public final static String VALUE_TO = " TO ";
	public final static String END_BRACKET = " }";
	public final static String SUGGEATIONS = "suggestions";
	public final static String ID = "id";
	public final static String ESTORE_PROPERTIES = "reporting.properties";
	public final static String ESTORE_HOST_URL = "solr.host.url";

	public enum SERVICE_TYPES {
		SEARCH, BROWSE, TYPEAHEAD, PDP
	}

	public enum PAGE_VIEWS {
		VIEW_12(12), VIEW_24(24), VIEW_36(36), VIEW_48(48), VIEW_60(60), VIEW_1(1);
		private int id;

		PAGE_VIEWS(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

	}

	public enum SORT_OPTIONS {
		ASCENDING(1), DESCENDING(2), RELEVANCE(3);
		private int id;

		SORT_OPTIONS(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

	}

	public enum SEARCH_ENGINE_TYPE {

		SOLR

	}
}
