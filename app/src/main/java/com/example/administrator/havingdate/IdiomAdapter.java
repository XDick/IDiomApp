package com.example.administrator.havingdate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/3/11.
 */

public class IdiomAdapter extends RecyclerView.Adapter<IdiomAdapter.ViewHolder> {
private Context mContext;
private List<Idiom> mIdiomList;

class ViewHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    ImageView idiomImage;
    TextView idiomName;
    TextView idiomContent;

    public ViewHolder(View view) {
        super(view);
        cardView = (CardView) view;
        idiomImage = view.findViewById(R.id.information_image);
        idiomName =  view.findViewById(R.id.information_name);
        idiomContent = view.findViewById(R.id.information_content);

    }
}



    public IdiomAdapter(List<Idiom> idiomList){
        mIdiomList = idiomList;

    }
    @Override
    public IdiomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.information_item, parent, false);

        final IdiomAdapter.ViewHolder holder = new IdiomAdapter.ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Idiom idioms = mIdiomList.get(position);
                Intent intent = new Intent(mContext , InformationActivity.class);
                intent.putExtra(InformationActivity.INFORMATION_NAME,idioms.getTitle());
                intent.putExtra("image_url",idioms.getImageId());
                intent.putExtra("idiom_content",idioms.getContent());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(IdiomAdapter.ViewHolder holder, int position){


        Idiom idiom = mIdiomList.get(position);
        holder. idiomName.setText(idiom.getTitle());
        holder. idiomContent.setText(idiom.getBody());
        Glide.with(mContext).load(idiom.getImageId()).into(holder. idiomImage);

    }
    @Override
    public int getItemCount(){
        return mIdiomList.size();
    }

}
