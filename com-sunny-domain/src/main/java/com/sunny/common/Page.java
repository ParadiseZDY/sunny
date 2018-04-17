package com.sunny.common;

import java.io.Serializable;

/**
 * 分页
 *
 * @author zhao.dy
 * @date 12:22 2018/4/16
 */
public abstract class Page implements Serializable {

	private static final long serialVersionUID = 4271243427231421634L;
	public final static int DEFAULT_PAGE_No = 1;
	public final static int DEFAULT_PAGE_SIZE = 20;

	private Integer pageNo = DEFAULT_PAGE_No;
	private Integer pageSize = DEFAULT_PAGE_SIZE;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartOfPage() {
		if (pageNo == 0) {
			// 页数是从第一页是从1开始计算的
			pageNo = DEFAULT_PAGE_No;
		}
		return (pageNo - 1) * pageSize;
	}

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
