package com.kengoweb.easymarkets.filter;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.kengoweb.easymarkets.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends Fragment {

    public static final String TAG = FilterFragment.class.getSimpleName();

    @BindView(R.id.spinner_bedrooms)
    Spinner spinnerBedrooms;

    @BindView(R.id.et_startdate)
    EditText etStartDate;

    @BindView(R.id.et_enddate)
    EditText etEndDate;

    private FilterViewModel filterViewModel;

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        filterViewModel = ViewModelProviders.of(getActivity()).get(FilterViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_filter_appartment, container, false);
        getActivity().setTitle(R.string.filter_appartments);
        ButterKnife.bind(this, rootView);

        initViews();

        return rootView;
    }

    private void initViews() {
        Integer[] items = new Integer[]{1, 2, 3};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinnerBedrooms.setAdapter(adapter);

        FilterData currentFilterData = filterViewModel.getFilter().getValue();
        if (currentFilterData != null) {
            spinnerBedrooms.setSelection(currentFilterData.getBedrooms() - 1);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @OnClick(R.id.btn_filter)
    public void onFilterClick() {
        int bedroomsFilter = (int) spinnerBedrooms.getSelectedItem();
        Date fromDateFilter = new Date();
        Date endDateFilter = new Date();
        filterViewModel.setFilterData(new FilterData(bedroomsFilter, fromDateFilter, endDateFilter));
        getActivity().onBackPressed();
    }

    @OnClick(R.id.btn_clear_filter)
    public void onClearFilterClick() {
        filterViewModel.setFilterData(null);
        getActivity().onBackPressed();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
