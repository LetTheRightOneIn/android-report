package com.example.a12481.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Student> StudentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStudents();
        StudentAdapter adapter = new StudentAdapter(MainActivity.this,R.layout.student_item,StudentList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initStudents(){
        for(int i =0;i<3;i++) {
            Student liu = new Student("liu", 1, 1001, "男", 100123);
            StudentList.add(liu);
            Student zhao = new Student("zhao", 2, 1002, "女", 100456);
            StudentList.add(zhao);
            Student qian = new Student("qian", 3, 1003, "男", 100789);
            StudentList.add(qian);
            Student sun = new Student("sun", 4, 1004, "女", 123456);
            StudentList.add(sun);
            Student li = new Student("li", 5, 1005, "男", 987654);
            StudentList.add(li);
            Student zhou = new Student("zhou", 6, 1006, "女", 134569);
            StudentList.add(zhou);
            Student zhang = new Student("zhang", 7, 1007, "男", 978945);
            StudentList.add(zhang);
            Student yang = new Student("yang", 8, 1008, "男", 987654);
            StudentList.add(yang);
            Student hua = new Student("hua", 9, 1009, "女", 134569);
            StudentList.add(hua);
            Student tang = new Student("tang", 10, 1010, "男", 978945);
            StudentList.add(tang);
        }
    }
}
