package com.seres.module.data;

import lombok.Data;



@Data
public class Pagination {

	private Long total;
	private Integer pageSize;
	private Integer current;

	public Pagination() {
		super();
	}

	public Pagination(Long total, Integer pageSize, Integer current) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.current = current;
	}

}
