package model.dao.impl;

import model.dao.SellerDao;

public class DaoFactory {

    public static SellerDao CreateSellerDao(){
        return new SellerDaoJDBC();
    }

}
