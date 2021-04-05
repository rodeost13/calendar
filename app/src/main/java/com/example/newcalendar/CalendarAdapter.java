package com.example.newcalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class CalendarAdapter extends BaseAdapter
{
    private ArrayList<DayInfo> mDayList;
    private Context mContext;
    private int mResource;
    private LayoutInflater mLiInflater;

    public CalendarAdapter(Context context, int textResource, ArrayList<DayInfo> dayList)
    {
        this.mContext = context;
        this.mDayList = dayList;
        this.mResource = textResource;
        this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return mDayList.size();
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return mDayList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        DayInfo day = mDayList.get(position);

        DayViewHolde dayViewHolder;

        if(convertView == null)
        {
            convertView = mLiInflater.inflate(mResource, null);

            if(position % 7 == 6)
            {
                convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP()+getRestCellWidthDP(), getCellHeightDP()));
            }
            else
            {
                convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP(), getCellHeightDP()));
            }


            dayViewHolder = new DayViewHolde();


            dayViewHolder.tvDay =  convertView.findViewById(R.id.day);

            convertView.setTag(dayViewHolder);
        }
        else
        {
            dayViewHolder = (DayViewHolde) convertView.getTag();
        }

        if(day != null)
        {
            dayViewHolder.tvDay.setText(day.getDay());

            if(day.isInMonth())
            {
                if(position % 7 == 0)
                {
                    dayViewHolder.tvDay.setTextColor(Color.BLACK);
                }
                else if(position % 7 == 6)
                {
                    dayViewHolder.tvDay.setTextColor(Color.BLACK);
                }
                else
                {
                    dayViewHolder.tvDay.setTextColor(Color.BLACK);
                }
            }
            else
            {
                dayViewHolder.tvDay.setTextColor(Color.GRAY);
            }

        }

        return convertView;
    }

    public class DayViewHolde
    {

        public TextView tvDay;

    }

    private int getCellWidthDP()
    {
        int cellWidth = 480/7;

        return cellWidth;
    }

    private int getRestCellWidthDP()
    {
        int cellWidth = 480%7;

        return cellWidth;
    }

    private int getCellHeightDP()
    {
        int cellHeight = 480/6;

        return cellHeight;
    }

}


