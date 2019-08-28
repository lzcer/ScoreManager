package com.example.scoremanager.db;

public class Databese {
    public static final class Student{
        /**
         * 表名
         */
        public static final String TABLE_NAME="students";

        /**
         * 字段名
         */
        public static final class Column{
            public static final String ID="id";
            public static final String NAME="name";//姓名
            public static final String STU_ID="stuId";//学号
            public static final String INTERIOR="interior";//内务分
            public static final String MORALE="morale";//军容风纪
            public static final String DISCIPLINE="discipline";//遵章守纪
            public static final String BEHAVE="behave";//个人表现
            public static final String ACTIVE="active";//参加活动
            public static final String JC="jc";//奖惩情况
            public static final String MEMBER="member";//团学情况
            public static final String CADRE="cadre";//担任骨干
            public static final String STAMINA="stamina";//体能考核
            public static final String LEARN="learn";//学习成绩
            public static final String TOTAL="total";//量化分总分
        }
    }
}
