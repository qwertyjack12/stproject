package com.example.stproject.server;

public class ProjectInfo {
    private static ProjectInfo instance;
    private Integer StudentId;
    private ProjectInfo(){}

    public Integer getStudentId() {return StudentId;}
    public void setStudentId(Integer studentId) {StudentId = studentId;}

    public static synchronized ProjectInfo getState() {
        if(instance == null){
            instance = new ProjectInfo();
        }
        return instance;
    }

}
