package model.dao.impl;

import db.DB;
import model.dao.SellerDao;

import java.sql.Connection;

public class DaoFactory {

    public static SellerDao CreateSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

}
