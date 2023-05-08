package com.example.zp.users;

import com.example.zp.groups.Group;
import com.example.zp.discipline.Discipline;

public interface TeacherInterface {
    void addDiscipline(Discipline<?> discipline);
    void addGroup(Discipline<?> discipline, Group group);
    void removeDiscipline(Discipline<?> discipline);
    void removeGroupInDiscipline(Discipline<?> discipline, Group group);
    String getStudentsForDiscipline(Discipline<?> discipline);
}
