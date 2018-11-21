package com.kengoweb.easymarkets.filter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class FilterViewModel extends ViewModel {
    private final MutableLiveData<FilterData> filterData = new MutableLiveData<>();

    public void setFilterData(FilterData filterData) {
        this.filterData.setValue(filterData);
    }

    public LiveData<FilterData> getFilter() {
        return filterData;
    }
}
