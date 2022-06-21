/*
 *  Copyright (C) HAND Enterprise Solutions Company Ltd.
 *  All Rights Reserved
 */

package com.seres.module.data;

import com.github.pagehelper.Page;

import javax.validation.Valid;
import java.util.List;


public class PageRespDTO<T> {

	/**
	 * 数据信息
	 */
	@Valid
	private List<T> list;

	/**
	 * 分页信息
	 */
	private Pagination pagination;

	public PageRespDTO() {
	}

	public PageRespDTO(List<T> list) {
		this.list = list;
		this.pagination = new Pagination();
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.pagination.setCurrent(page.getPageNum());
			this.pagination.setPageSize(page.getPageSize());
			this.pagination.setTotal(page.getTotal());
		} else if (list != null) {
			this.pagination.setCurrent(1);
			this.pagination.setPageSize(list.size());
			this.pagination.setTotal((long) list.size());
		}
	}

	public PageRespDTO(Page<Object> page) {
		Pagination dto = new Pagination();
		dto.setCurrent(page.getPageNum());
		dto.setPageSize(page.getPageSize());
		dto.setTotal(page.getTotal());
		this.pagination = dto;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
