package com.example.scoremanager;

import android.content.Context;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.scoremanager.entity.Student;

import java.util.List;
import java.util.zip.Inflater;

public class ItemAdapter extends BaseAdapter {
    Boolean isClick=true;
    LayoutInflater inflater;
    Context context;
    List<Student> students;

    public ItemAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return students.size()==0? 1:students.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean isEnabled(int position) {
        return isClick;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
        if (convertView == null) {
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.list_item,null);
            holder.name=convertView.findViewById(R.id.item_name);
            holder.stuId=convertView.findViewById(R.id.item_stuId);
            holder.total=convertView.findViewById(R.id.item_total);
            convertView.setTag(holder);
        }
        holder= (ViewHolder) convertView.getTag();
        if (students.size()!=0){
            holder.name.setText("姓名："+students.get(position).getName());
            holder.stuId.setText("学号："+students.get(position).getStuId());
            holder.total.setText("总分:"+students.get(position).getTotal());
        }else {
            holder.stuId.setText("暂无相关信息");
            isClick=false;
        }

        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView stuId;
        TextView total;
    }
}
