package com.kengoweb.easymarkets.filter;

import java.util.Date;

public class FilterData {
    private int bedrooms;
    private Date fromDate;
    private Date endDate;

    public FilterData(int bedroomsFilter, Date fromDateFilter, Date endDateFilter) {
        this.bedrooms = bedroomsFilter;
        this.fromDate = fromDateFilter;
        this.endDate = endDateFilter;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
