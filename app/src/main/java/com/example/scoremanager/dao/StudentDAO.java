package com.example.scoremanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import com.example.scoremanager.db.DBOpenHelper;
import com.example.scoremanager.db.Databese;
import com.example.scoremanager.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Context context;

    public StudentDAO(Context context) {
        this.context = context;
    }
    DBOpenHelper openHelper;
    SQLiteDatabase db;
    String table_name=Databese.Student.TABLE_NAME;
    String id=Databese.Student.Column.STU_ID;

    /**
     * 查询
     * @param where
     * @param whereArgs
     * @return
     */
    public List<Student> list(String where ,String[] whereArgs){
        openHelper=new DBOpenHelper(context);
        db=openHelper.getReadableDatabase();
        List<Student> students=new ArrayList<>();
        Cursor cursor=db.query(table_name,null,where,whereArgs,
                null,null,id+" DESC");
        if (cursor.getCount()!=0){
            while (cursor.moveToNext()){
                Student student=new Student();
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setStuId(cursor.getInt(2));
                student.setInterior(cursor.getInt(3));
                student.setMorale(cursor.getInt(4));
                student.setDiscipline(cursor.getInt(5));
                student.setBehave(cursor.getInt(6));
                student.setActive(cursor.getInt(7));
                student.setJc(cursor.getInt(8));
                student.setMember(cursor.getInt(9));
                student.setCadre(cursor.getInt(10));
                student.setStamina(cursor.getInt(11));
                student.setLearn(cursor.getInt(12));
                student.setTotal(cursor.getInt(13));
                students.add(student);
            }
        }
        db.close();
        return students;
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    public long add(Student student){
        openHelper=new DBOpenHelper(context);
        db=openHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(Databese.Student.Column.NAME,student.getName());
        values.put(Databese.Student.Column.STU_ID,student.getStuId());
        values.put(Databese.Student.Column.INTERIOR,student.getInterior());
        values.put(Databese.Student.Column.MORALE,student.getMorale());
        values.put(Databese.Student.Column.DISCIPLINE,student.getDiscipline());
        values.put(Databese.Student.Column.BEHAVE,student.getBehave());
        values.put(Databese.Student.Column.ACTIVE,student.getActive());
        values.put(Databese.Student.Column.JC,student.getJc());
        values.put(Databese.Student.Column.MEMBER,student.getMember());
        values.put(Databese.Student.Column.CADRE,student.getCadre());
        values.put(Databese.Student.Column.STAMINA,student.getStamina());
        values.put(Databese.Student.Column.LEARN,student.getLearn());
        values.put(Databese.Student.Column.TOTAL,student.getTotal());
        long count=db.insert(table_name,null,values);
        db.close();
        return count;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public long update(Student student){
        openHelper=new DBOpenHelper(context);
        db=openHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(Databese.Student.Column.NAME,student.getName());
        values.put(Databese.Student.Column.STU_ID,student.getStuId());
        values.put(Databese.Student.Column.INTERIOR,student.getInterior());
        values.put(Databese.Student.Column.MORALE,student.getMorale());
        values.put(Databese.Student.Column.DISCIPLINE,student.getDiscipline());
        values.put(Databese.Student.Column.BEHAVE,student.getBehave());
        values.put(Databese.Student.Column.ACTIVE,student.getActive());
        values.put(Databese.Student.Column.JC,student.getJc());
        values.put(Databese.Student.Column.MEMBER,student.getMember());
        values.put(Databese.Student.Column.CADRE,student.getCadre());
        values.put(Databese.Student.Column.STAMINA,student.getStamina());
        values.put(Databese.Student.Column.LEARN,student.getLearn());
        values.put(Databese.Student.Column.TOTAL,student.getTotal());
        String where =Databese.Student.Column.STU_ID +"=?";
        String[] whereArgs={""+student.getStuId()};
        long count=db.update(table_name,values,where,whereArgs);
        db.close();
        return count;
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    public long delete(long id){
        openHelper=new DBOpenHelper(context);
        db=openHelper.getReadableDatabase();
        String where =Databese.Student.Column.STU_ID +"=?";
        String[] whereArgs={""+id};
        long count=db.delete(table_name,where,whereArgs);
        db.close();
        return count;
    }
    public int getCount(){
        return list(null,null).size();
    }
}
