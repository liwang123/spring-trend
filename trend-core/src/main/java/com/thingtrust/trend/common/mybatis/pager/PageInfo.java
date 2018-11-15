package com.thingtrust.trend.common.mybatis.pager;

import java.util.List;

public class PageInfo {

    public static final String SORT_TYPE_ASC = "asc";
    public static final String SORT_TYPE_DES = "desc";
    private long totals;
    private int startIndex;
    private int pageSize;
    private String sortItem;
    private String sortType;
    private List listObject;


    public PageInfo(final int startIndex, final int pageSize) {
        this((startIndex - 1) * pageSize, pageSize, "", "desc");
    }

    public PageInfo(final int startIndex, final int pageSize, final String sortItem) {
        this((startIndex - 1) * pageSize, pageSize, sortItem, "desc");
    }

    public PageInfo(final int startIndex, final int pageSize, final String sortItem, final String sortType) {
        this.pageSize = 50;
        this.sortType = "desc";
        this.startIndex = startIndex;
        this.pageSize = pageSize;
        this.sortItem = sortItem;
        this.sortType = sortType;
    }

    public long getTotals() {
        return totals;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getSortItem() {
        return sortItem;
    }

    public String getSortType() {
        return sortType;
    }

    public List<Object> getListObject() {
        return listObject;
    }

    public void setTotals(final long totals) {
        this.totals = totals;
    }

    public void setStartIndex(final int startIndex) {
        this.startIndex = startIndex;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortItem(final String sortItem) {
        this.sortItem = sortItem;
    }

    public void setSortType(final String sortType) {
        this.sortType = sortType;
    }

    public void setListObject(final List listObject) {
        this.listObject = listObject;
    }


    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageInfo)) {
            return false;
        } else {
            final PageInfo other = (PageInfo) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (getTotals() != other.getTotals()) {
                return false;
            } else if (getStartIndex() != other.getStartIndex()) {
                return false;
            } else if (getPageSize() != other.getPageSize()) {
                return false;
            } else {
                final Object this$sortItem = getSortItem();
                final Object other$sortItem = other.getSortItem();
                if (this$sortItem == null) {
                    if (other$sortItem != null) {
                        return false;
                    }
                } else if (!this$sortItem.equals(other$sortItem)) {
                    return false;
                }

                final Object this$sortType = getSortType();
                final Object other$sortType = other.getSortType();
                if (this$sortType == null) {
                    if (other$sortType != null) {
                        return false;
                    }
                } else if (!this$sortType.equals(other$sortType)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageInfo;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final long $totals = getTotals();
        result = result * 59 + (int)($totals >>> 32 ^ $totals);
        result = result * 59 + getStartIndex();
        result = result * 59 + getPageSize();
        final Object $sortItem = getSortItem();
        result = result * 59 + ($sortItem == null ? 43 : $sortItem.hashCode());
        final Object $sortType = getSortType();
        result = result * 59 + ($sortType == null ? 43 : $sortType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PageInfo(totals=" + getTotals() + ", startIndex=" + getStartIndex() + ", pageSize=" + getPageSize() + ", sortItem=" + getSortItem() + ", sortType=" + getSortType() + ")";
    }

    public PageInfo() {
        pageSize = 50;
        sortType = "desc";
    }
}
