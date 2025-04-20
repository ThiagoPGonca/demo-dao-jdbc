package application;

import entities.Department;
import entities.Seller;
import model.dao.SellerDao;
import model.dao.impl.DaoFactory;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.CreateSellerDao();

        System.out.println("=== Tetes 1: Seller findById =====");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);



    }
}