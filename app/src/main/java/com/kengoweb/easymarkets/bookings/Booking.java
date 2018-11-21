package com.kengoweb.easymarkets.bookings;

import java.util.Date;

public class Booking {

    private Date startDate;
    private Date endDate;
    private int appartmentsId;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAppartmentsId() {
        return appartmentsId;
    }

    public void setAppartmentsId(int appartmentsId) {
        this.appartmentsId = appartmentsId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", appartmentsId=" + appartmentsId +
                '}';
    }
}
