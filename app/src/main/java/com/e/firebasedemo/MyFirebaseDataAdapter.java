package com.e.firebasedemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class MyFirebaseDataAdapter extends BaseAdapter {
    Context context;
    ArrayList<UserModel> userModelArrayList;
    public MyFirebaseDataAdapter(Context context,ArrayList<UserModel> userModelArrayList){
        this.context=context;
        this.userModelArrayList=userModelArrayList;

    }
    @Override
    public int getCount() {
        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.rawlist,null);
        TextView tvdata=convertView.findViewById(R.id.tv_name);
        tvdata.setText(userModelArrayList.get(position).getFirstName()+ " "+ userModelArrayList.get(position).getLastName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strId=userModelArrayList.get(position).getID();
                String strfn=userModelArrayList.get(position).getFirstName();
                String strln=userModelArrayList.get(position).getLastName();
                Intent i=new Intent(context,Update.class);
                i.putExtra("ID",strId);
                i.putExtra("FN",strfn);
                i.putExtra("LN",strln);
                context.startActivity(i);


            }
        });
        return convertView;

    }


}
