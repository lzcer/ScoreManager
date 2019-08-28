package com.example.scoremanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.scoremanager.dao.StudentDAO;
import com.example.scoremanager.db.DBOpenHelper;
import com.example.scoremanager.db.Databese;
import com.example.scoremanager.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAGD";
    private SearchView mMainSearch;
    private ListView mMainList;
    StudentDAO dao = new StudentDAO(this);
    List<Student> students;
    long istime=0;
    //截取返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (System.currentTimeMillis()-istime>2000){
            Toast.makeText(this, "再按一次退出程序！", Toast.LENGTH_SHORT).show();
            istime=System.currentTimeMillis();
        }else{
            finish();
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
        listener();
    }

    private void listener() {
        mMainSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {//点击搜索提交
                if ("".equals(s)) {
                    Toast.makeText(MainActivity.this, "请输入搜索内容", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {//文本改变
                if ("".equals(s)) {//如果搜索框是空的，就显示原始内容，不然会显示两组重复数据
                    setView();
                } else {
                    List<Student> students=new ArrayList<>();
                    List<Student> students1 = dao.list(Databese.Student.Column.NAME + " like ?", new String[]{"%" + s + "%"});//对姓名模糊查询
                    List<Student> students2 = dao.list(Databese.Student.Column.STU_ID + " like ?", new String[]{"%" + s + "%"});
                    for (Student student : students1) {
                        students.add(student);
                    }//遍历姓名查询集合
                    for (Student student : students2) {
                        students.add(student);
                    }//遍历学号查询集合
                    showList(students);
                }
                return false;
            }
        });
        mMainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,StudentItem.class);
                intent.putExtra("id",students.get(position).getId());
                startActivity(intent);
            }
        });
    }

    private void setView() {
        students = dao.list(null, null);
        Log.d(TAG, "setView: ----------->" + students);
        showList(students);
    }
    private void showList(List<Student> students) {
        ItemAdapter adapter = new ItemAdapter(this, students);
        mMainList.setAdapter(adapter);
    }

    private void initView() {
        mMainSearch = (SearchView) findViewById(R.id.main_Search);
        mMainList = (ListView) findViewById(R.id.main_list);
    }

    public void add(View view) {
        startActivity(new Intent(MainActivity.this,AddStudent.class));
    }
}
