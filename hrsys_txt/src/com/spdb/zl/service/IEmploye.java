package com.spdb.zl.service;

import com.spdb.zl.bean.Employe;

import java.util.List;

public interface IEmploye {
    void addEmploye();
    void deleteEmploye();
    void updateEmploye();
    boolean findByName(String name);
    List<Employe> readAllEmploye();
    void printEmploy();
}
