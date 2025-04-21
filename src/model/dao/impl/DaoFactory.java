package model.dao.impl;

import db.DB;
import entities.Department;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

import java.sql.Connection;
import java.util.List;

public class DaoFactory {

    public static SellerDao CreateSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
    public static DepartmentDao CreateDepartmentDao(){return new DepartmentDaoJDBC(DB.getConnection());}
}
