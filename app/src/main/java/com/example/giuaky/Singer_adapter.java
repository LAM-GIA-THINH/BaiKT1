package com.example.giuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Singer_adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Singer> singerList;

    public Singer_adapter(Context context, int layout, List<Singer> menuList) {
        this.context = context;
        this.layout = layout;
        singerList = menuList;
    }

    @Override
    public int getCount() {
        return singerList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen;
        TextView txtMota;
        TextView txtQuocgia;
        TextView txtSosao;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) view.findViewById(R.id.textViewTen);
            holder.txtMota = (TextView) view.findViewById(R.id.textViewMota);
            holder.txtQuocgia = (TextView) view.findViewById(R.id.textViewquocgia);
            holder.txtSosao = (TextView) view.findViewById(R.id.textViewsao);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imageViewHinh);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }

        Singer menu = singerList.get(i);
        holder.txtTen.setText(menu.getTen());
        holder.txtMota.setText(menu.getMoTa());
        holder.txtQuocgia.setText(menu.getQuocGia());
        holder.txtSosao.setText(menu.getSoSao());
        holder.imgHinh.setImageResource(menu.getHinh());
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list);
        view.startAnimation(animation);
        return view;

    }

}
