package com.mbkhack.glinkle.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbkhack.glinkle.DonateActivity;
import com.mbkhack.glinkle.GlinkleApplication;
import com.mbkhack.glinkle.MainActivity;
import com.mbkhack.glinkle.R;
import com.mbkhack.glinkle.adapter.CharityAdapter;
import com.mbkhack.glinkle.model.Charity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnsonma on 2/27/16.
 */
public abstract class CharityListFragment extends BaseFragment {

    RecyclerView rv_list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_charitylist, container, false);
        rv_list = (RecyclerView) rootView.findViewById(R.id.rv_list);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_list.setLayoutManager(llm);

        GlinkleApplication application = (GlinkleApplication) getActivity().getApplication();

        CharityAdapter charityAdapter = new CharityAdapter(getActivity(), application.getCharityManager().getCharityList());
        charityAdapter.setOnClickListener(new CharityAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DonateActivity.class);
                intent.putExtra(DonateActivity.PARAM_CHARITY_ID, position);
                CharityListFragment.this.startActivityForResult(intent, 1);
            }
        });

        rv_list.setAdapter(charityAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                ((MainActivity) getActivity()).gotoHomePage();
            }
        }
    }
}