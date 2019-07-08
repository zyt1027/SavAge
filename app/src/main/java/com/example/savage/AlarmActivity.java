package com.example.savage;

import java.util.Date;

class AlarmActivity {

    private Date activityTime;
    private String description;
    private int priority;
    private int repeatDay;


    public AlarmActivity(){}

    public AlarmActivity(int priority, Date activityTime,int repeatDay,String description){
        this.setActivityTime(activityTime);
        this.setDescription(description);
        this.setPriority(priority);
        this.setRepeatDay(repeatDay);
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRepeatDay() {
        return repeatDay;
    }

    public void setRepeatDay(int repeatDay) {
        this.repeatDay = repeatDay;
    }





}
