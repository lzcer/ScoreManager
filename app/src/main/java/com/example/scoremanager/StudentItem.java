package com.example.scoremanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scoremanager.dao.StudentDAO;
import com.example.scoremanager.entity.Student;

import java.util.List;

public class StudentItem extends AppCompatActivity {
    private static final String TAG = "TAGD";
    private Boolean isSave = true;//判断是否保存,初始因为true因为刚进来肯定未改变
    Student student;
    /**
     * 姓名
     */
    private TextView mStuItName;
    /**
     * 学号
     */
    private TextView mStuItUId;
    /**
     * 内务分
     */
    private EditText mStuItNeiwu;
    /**
     * 军容风纪
     */
    private EditText mStuItJunrong;
    /**
     * 遵章守纪
     */
    private EditText mStuItZunzhang;
    /**
     * 个人表现
     */
    private EditText mStuItBiaoxian;
    /**
     * 参加活动
     */
    private EditText mStuItCanjia;
    /**
     * 奖惩情况
     */
    private EditText mStuItJiangcheng;
    /**
     * 团学情况
     */
    private EditText mStuItTuanxue;
    /**
     * 担任骨干
     */
    private EditText mStuItGugan;
    /**
     * 体能考核
     */
    private EditText mStuItTineng;
    /**
     * 学习成绩
     */
    private EditText mStuItXuexi;
    /**
     * 80
     */
    private TextView mZongfen;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isSave) {
            finish();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示！");
            builder.setMessage("新变更未更改,确认退出吗？");
            builder.setNeutralButton("取消", null);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_item);
        initView();
        showView();
        changedListener();
    }
    private void changedListener() {
        //每次输入框内容发生改变就刷新判断保存变量并刷新总分
        mStuItNeiwu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){
                    mStuItNeiwu.setText("0");
                }
                showTatol();
            }
        });
        mStuItJunrong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItJunrong.setText("0");}
                showTatol();
            }
        });
        mStuItZunzhang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItZunzhang.setText("0");}
                showTatol();
            }
        });
        mStuItBiaoxian.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItBiaoxian.setText("0");}
                showTatol();
            }
        });
        mStuItCanjia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItCanjia.setText("0");}
                showTatol();
            }
        });
        mStuItJiangcheng.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItJiangcheng.setText("0");}
                showTatol();
            }
        });
        mStuItTuanxue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItTuanxue.setText("0");}
                showTatol();
            }
        });
        mStuItGugan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItGugan.setText("0");}
                showTatol();
            }
        });
        mStuItTineng.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItTineng.setText("0");}
                showTatol();
            }
        });
        mStuItXuexi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isSave = false;//输入框内容改变刷新判断保存变量
                if (s.length()==0){mStuItXuexi.setText("0");}
                showTatol();
            }
        });
    }
    private void showTatol(){
        int tatol=80;
        tatol+=Integer.parseInt(mStuItNeiwu.getText().toString().equals("") ? "0":mStuItNeiwu.getText().toString());
        tatol+=Integer.parseInt(mStuItJunrong.getText().toString().equals("") ? "0":mStuItJunrong.getText().toString());
        tatol+=Integer.parseInt(mStuItZunzhang.getText().toString().equals("") ? "0":mStuItZunzhang.getText().toString());
        tatol+=Integer.parseInt(mStuItBiaoxian.getText().toString().equals("") ? "0":mStuItBiaoxian.getText().toString());
        tatol+=Integer.parseInt(mStuItCanjia.getText().toString().equals("") ? "0":mStuItCanjia.getText().toString());
        tatol+=Integer.parseInt(mStuItJiangcheng.getText().toString().equals("") ? "0":mStuItJiangcheng.getText().toString());
        tatol+=Integer.parseInt(mStuItTuanxue.getText().toString().equals("") ? "0":mStuItTuanxue.getText().toString());
        tatol+=Integer.parseInt(mStuItGugan.getText().toString().equals("") ? "0":mStuItGugan.getText().toString());
        tatol+=Integer.parseInt(mStuItTineng.getText().toString().equals("") ? "0":mStuItTineng.getText().toString());
        tatol+=Integer.parseInt(mStuItXuexi.getText().toString().equals("") ? "0":mStuItXuexi.getText().toString());
        mZongfen.setText(tatol+"");
    }
    private void showView() {
        Log.d(TAG, "showView: ------------------"+student);
        //显示学生各项信息
        mStuItName.setText(student.getName());
        mStuItUId.setText("" + student.getStuId());
        mStuItNeiwu.setText("" + student.getInterior());
        mStuItJunrong.setText("" + student.getMorale());
        mStuItZunzhang.setText("" + student.getDiscipline());
        mStuItBiaoxian.setText("" + student.getBehave());
        mStuItCanjia.setText("" + student.getActive());
        mStuItJiangcheng.setText("" + student.getJc());
        mStuItTuanxue.setText("" + student.getMember());
        mStuItGugan.setText("" + student.getCadre());
        mStuItTineng.setText("" + student.getStamina());
        mStuItXuexi.setText("" + student.getLearn());
        mZongfen.setText("" + student.getTotal());
    }

    private void initView() {
        //从intent中获取从上个活动中传递的id
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        if (id != -1) {
            StudentDAO dao = new StudentDAO(this);
            //获取该id对应学生
            List<Student> students = dao.list("id=?", new String[]{id + ""});
            for (Student student1 : students) {
                student = student1;
            }
        }
        mStuItName =  findViewById(R.id.stu_it_name);
        mStuItUId =  findViewById(R.id.stu_it_uId);
        mStuItNeiwu = (EditText) findViewById(R.id.stu_it_neiwu);
        mStuItJunrong = (EditText) findViewById(R.id.stu_it_junrong);
        mStuItZunzhang = (EditText) findViewById(R.id.stu_it_zunzhang);
        mStuItBiaoxian = (EditText) findViewById(R.id.stu_it_biaoxian);
        mStuItCanjia = (EditText) findViewById(R.id.stu_it_canjia);
        mStuItJiangcheng = (EditText) findViewById(R.id.stu_it_jiangcheng);
        mStuItTuanxue = (EditText) findViewById(R.id.stu_it_tuanxue);
        mStuItGugan = (EditText) findViewById(R.id.stu_it_gugan);
        mStuItTineng = (EditText) findViewById(R.id.stu_it_tineng);
        mStuItXuexi = (EditText) findViewById(R.id.stu_it_xuexi);
        mZongfen = (TextView) findViewById(R.id.zongfen);
    }

    public void save(View view) {
        StudentDAO dao=new StudentDAO(this);
        Student student=new Student();
        student.setName(mStuItName.getText().toString());
        long id= Long.parseLong(mStuItUId.getText().toString());
        student.setStuId(id);
        student.setInterior(Integer.parseInt(mStuItNeiwu.getText().toString()));
        student.setMorale(Integer.parseInt(mStuItJunrong.getText().toString()));
        student.setDiscipline(Integer.parseInt(mStuItZunzhang.getText().toString()));
        student.setBehave(Integer.parseInt(mStuItBiaoxian.getText().toString()));
        student.setActive(Integer.parseInt(mStuItCanjia.getText().toString()));
        student.setJc(Integer.parseInt(mStuItJiangcheng.getText().toString()));
        student.setMember(Integer.parseInt(mStuItTuanxue.getText().toString()));
        student.setCadre(Integer.parseInt(mStuItGugan.getText().toString()));
        student.setStamina(Integer.parseInt(mStuItTineng.getText().toString()));
        student.setLearn(Integer.parseInt(mStuItXuexi.getText().toString()));
        student.setTotal(Integer.parseInt(mZongfen.getText().toString()));
        long a=dao.update(student);
        if (a>0){
            Toast.makeText(this, "保存成功！", Toast.LENGTH_SHORT).show();
            isSave = true;
        }
    }

    public void back(View view) {
        if (isSave) {
                finish();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示！");
                builder.setMessage("新变更未更改,确认退出吗？");
                builder.setNeutralButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
        }
    }

    public void delete(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示！");
        builder.setMessage("点击确认删除此条信息（不可恢复）");
        builder.setNeutralButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StudentDAO dao=new StudentDAO(StudentItem.this);
                dao.delete(student.getStuId());
                finish();
            }
        });
        builder.show();
    }
}
