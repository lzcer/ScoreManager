package com.example.scoremanager.entity;

public class Student {
    private int id;

    private String name;//姓名
    private long stuId;//学号

    private int interior;//内务分
    private int morale;//军容风纪

    private int discipline;//遵章守纪
    private int behave;//个人表现

    private int active;//参加活动
    private int jc;//奖惩情况

    private int member;//团学情况
    private int cadre;//担任骨干

    private int stamina;//体能考核
    private int learn;//学习成绩

    private int total;//量化分总分

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stuId=" + stuId +
                ", interior=" + interior +
                ", morale=" + morale +
                ", discipline=" + discipline +
                ", behave=" + behave +
                ", active=" + active +
                ", jc=" + jc +
                ", member=" + member +
                ", cadre=" + cadre +
                ", stamina=" + stamina +
                ", learn=" + learn +
                ", total=" + total +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public int getInterior() {
        return interior;
    }

    public void setInterior(int interior) {
        this.interior = interior;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public int getDiscipline() {
        return discipline;
    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public int getBehave() {
        return behave;
    }

    public void setBehave(int behave) {
        this.behave = behave;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getJc() {
        return jc;
    }

    public void setJc(int jc) {
        this.jc = jc;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getCadre() {
        return cadre;
    }

    public void setCadre(int cadre) {
        this.cadre = cadre;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getLearn() {
        return learn;
    }

    public void setLearn(int learn) {
        this.learn = learn;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
