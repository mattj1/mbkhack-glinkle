package com.mbkhack.glinkle.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbkhack.glinkle.DonateActivity;
import com.mbkhack.glinkle.R;
import com.mbkhack.glinkle.model.Charity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharityAdapter extends RecyclerView.Adapter<CharityAdapter.CharityViewHolder> {

    public interface OnClickListener {
        void onClick(int position);
    }

    private Context context;
    private List<Charity> charityList;
    private OnClickListener onClickListener;

    public CharityAdapter(Context context, List<Charity> charityList) {
        this.context = context;
        this.charityList = charityList;
    }

    @Override
    public CharityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.layout_charity, parent, false);

        return new CharityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CharityViewHolder holder, final int position) {
        Charity charity = charityList.get(position);
        holder.tv_charityname.setText(charity.getName());
        holder.tv_charitydescription.setText(charity.getDescription());

        Picasso.with(context).load(charity.getImageURL()).into(holder.iv_image);

        holder.btn_donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onClickListener != null) {
                    onClickListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return charityList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class CharityViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_charityname)
        TextView tv_charityname;

        @Bind(R.id.tv_charitydescription)
        TextView tv_charitydescription;

        @Bind(R.id.iv_image)
        ImageView iv_image;

        @Bind(R.id.btn_donate)
        Button btn_donate;

        public CharityViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}