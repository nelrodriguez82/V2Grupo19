package com.example.ofertasenamap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter< ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater; //Archivo del que proviene
    private Context context;//Clase que llamamos al adapter

    public ListAdapter(List<ListElement> itemList,Context context) {
        this.mData = itemList;
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement> items){
        mData = items;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, country, status;

       public ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            country = itemView.findViewById(R.id.countryTextView);
            status = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(final ListElement item){
            //iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            iconImage.setImageResource(item.getColor());
            name.setText(item.getName());
            country.setText(item.getCountry());
            status.setText(item.getStatus());
        }
    }
}
