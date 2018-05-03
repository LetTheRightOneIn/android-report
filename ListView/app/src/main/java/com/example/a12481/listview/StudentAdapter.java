package com.example.a12481.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 12481 on 2018/5/3.
 */

public class StudentAdapter extends ArrayAdapter<Student> {
    private int resourceId;
    public StudentAdapter(Context context, int textViewResourceId, List<Student>objects){
        super(context,textViewResourceId,objects);
        resourceId =textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Student student = getItem(position);
        View view   = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView studentName = (TextView)view.findViewById(R.id.student_name);
        TextView studentClassnum = (TextView)view.findViewById(R.id.student_classnum);
        TextView studentNum= (TextView)view.findViewById(R.id.student_num);
        TextView studentSex = (TextView)view.findViewById(R.id.student_sex);
        TextView studentPho = (TextView)view.findViewById(R.id.student_pho);
        studentName.setText(student.getName());
        studentClassnum.setText(String.valueOf(student.getClassnum()));
        studentNum.setText(String.valueOf(student.getNum()));
        studentSex.setText(student.getSex().toString());
        studentPho.setText(String.valueOf(student.getPho()));
        return view;
    }
}

