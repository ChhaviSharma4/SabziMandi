package com.example.zeus.gharkimandi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zeus.gharkimandi.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rishi Madhok on 3/21/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    List<CommodityClass> data = Collections.emptyList();

    public RecyclerAdapter(Context context, List<CommodityClass> data)
    {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        CommodityClass current = data.get(position);
        holder.hcommodity.setText(current.commodity);
        holder.hprice.setText(current.modal_price);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView hcommodity,hprice;

        public MyViewHolder(View itemView) {
            super(itemView);

            hcommodity = (TextView) itemView.findViewById(R.id.commodity);
            hprice = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
