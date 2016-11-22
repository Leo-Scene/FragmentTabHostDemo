package com.puwang.dmeo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.puwang.dmeo.R;
import com.puwang.dmeo.bean.ItemInfo;

import java.util.ArrayList;

/**
 * Created by Leo on 2016/10/10.
 */

public class MRecyclerAdapter extends RecyclerView.Adapter<MRecyclerAdapter.ViewHolder> {

    private ArrayList<ItemInfo> mArrayList;
    private LayoutInflater mInflater;
    private OnItemClickListener listener;
    private int LAYOUT_R=0;
    private int LAYOUT_L=1;

  public void setOnItemClickListener(OnItemClickListener listener){
      this.listener = listener;
  }



    public  MRecyclerAdapter(ArrayList<ItemInfo> arrayList) {
        mArrayList = arrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        mInflater = LayoutInflater.from(parent.getContext());

        View view = mInflater.inflate(R.layout.recycler_item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(mArrayList.get(position).getName());
        holder.age.setText(mArrayList.get(position).getAge());
        holder.gender.setText(mArrayList.get(position).getGender());
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView age;
        private TextView gender;

        public ViewHolder(final View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
            gender = (TextView) itemView.findViewById(R.id.gender);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        listener.onClick(view,getLayoutPosition());
                    }
                }
            });

        }
    }



    public interface OnItemClickListener{
        void onClick(View v,int position);
    }




}
