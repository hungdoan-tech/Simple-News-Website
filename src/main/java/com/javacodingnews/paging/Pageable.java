package com.javacodingnews.paging;

import com.javacodingnews.sorting.Sorter;

public interface Pageable {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
