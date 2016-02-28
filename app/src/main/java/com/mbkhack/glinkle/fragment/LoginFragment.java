package com.mbkhack.glinkle.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mbkhack.glinkle.MainActivity;
import com.mbkhack.glinkle.R;

/**
 * Created by johnsonma on 2/27/16.
 */
public class LoginFragment extends BaseFragment {

    View rootView;

    @Override
    public String getTitle() {
        return "Home";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rootView.findViewById(R.id.btn_donate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).gotoDonatePage();
            }
        });
    }
}
