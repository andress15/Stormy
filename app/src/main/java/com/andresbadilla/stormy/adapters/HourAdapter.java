package com.andresbadilla.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andresbadilla.stormy.R;
import com.andresbadilla.stormy.weather.Hour;

/**
 * Created by Andres Badilla on 9/20/2015.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Context context,Hour[] hours){
        mHours = hours;
        mContext = context;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hourly_list_item,viewGroup,false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    @Override
    public void onBindViewHolder(HourViewHolder hourViewHolder, int i) {
        hourViewHolder.bindHour(mHours[i]);
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTimeLabel;
        public TextView mSummaryLabel;
        public TextView mTemperatureLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);
            mTimeLabel= (TextView) itemView.findViewById(R.id.timeLabel);
            mSummaryLabel= (TextView) itemView.findViewById(R.id.summaryLabel);
            mTemperatureLabel=(TextView) itemView.findViewById(R.id.temperatureLabel);
            mIconImageView=(ImageView) itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour){
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperature()+"");
            mIconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View view) {
            String time = mTimeLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString();
            String temperature = mTemperatureLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s", time, temperature,summary);

            Toast.makeText(mContext,message, Toast.LENGTH_LONG).show();
        }
    }
}
