package com.javacodingnews.paging;

import com.javacodingnews.sorting.Sorter;

public class PageRequest implements Pageable {

	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;

	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}
	
	@Override
	public Sorter getSorter() {
		return this.sorter;
	}
	
	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		if(this.getPage() == null || this.getLimit() == null)
		{
			return null;
		}
		return this.getPage() * this.getLimit();
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}

}
