package com.example.zeus.gharkimandi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zeus.gharkimandi.R;

import java.util.ArrayList;

/**
 * Created by Zeus on 4/17/2016.
 */
public class CommodityAdapter extends ArrayAdapter<CommodityClass> {
    ArrayList<CommodityClass> data;
    Context context;
    public CommodityAdapter(Context context, ArrayList<CommodityClass> objects) {
        super(context, 0, objects);
        this.context=context;
        data=objects;
    }

    public class ViewHolder{
        TextView commodityNameTv;
        TextView varietyTv;
        TextView priceTv;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.last_activity_item,null);
            ViewHolder vh=new ViewHolder();
            vh.commodityNameTv=(TextView) convertView.findViewById(R.id.commodityNametv);
            vh.priceTv=(TextView) convertView.findViewById(R.id.pricetv);
            vh.varietyTv=(TextView) convertView.findViewById(R.id.varietytv);
            convertView.setTag(vh);
        }
        ViewHolder vh=(ViewHolder) convertView.getTag();
        CommodityClass cur=data.get(position);
        vh.varietyTv.setText("VARIETY: "+cur.variety);
        vh.commodityNameTv.setText("ITEM: "+cur.commodity);
        vh.priceTv.setText("Price: Rs "+String.valueOf((double)cur.modal_price/100)+"/Kg");

        return convertView;
    }
}
