package com.kengoweb.easymarkets.appartments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kengoweb.easymarkets.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppartmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppartmentFragment extends Fragment {

    public static final String TAG = AppartmentFragment.class.getSimpleName();

    private static final String ARG_APPARTMENT = "appartment";

    private Appartment mAppartment;

    @BindView(R.id.tv_appartment_name)
    TextView tvAppartmentName;

    public AppartmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param appartment Appartment.
     * @return A new instance of fragment AppartmentFragment.
     */
    public static AppartmentFragment newInstance(Appartment appartment) {
        AppartmentFragment fragment = new AppartmentFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_APPARTMENT, appartment);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAppartment = (Appartment) getArguments().getSerializable(ARG_APPARTMENT);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_appartment, container, false);
        getActivity().setTitle(mAppartment.getName());
        ButterKnife.bind(this, rootView);
        tvAppartmentName.setText(mAppartment.getName());
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @OnClick(R.id.btn_book)
    public void onBookClick() {
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
