package application;

import entities.Department;
import entities.Seller;
import model.dao.SellerDao;
import model.dao.impl.DaoFactory;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.CreateSellerDao();

        System.out.println("=== Tetes 1: Seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Tetes 2: Seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj:list){
            System.out.println(obj);
        }

        System.out.println("\n=== Tetes 3: Seller findAll =====");
        list = sellerDao.findAll();
        for(Seller obj:list){
            System.out.println(obj);
        }

        System.out.println("\n=== Tetes 4: Seller Insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

    }
}