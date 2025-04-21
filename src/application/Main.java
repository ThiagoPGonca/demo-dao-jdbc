package application;

import entities.Department;
import entities.Seller;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DaoFactory;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.CreateDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: insert =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
       /*
       SellerDao

        SellerDao sellerDao = DaoFactory.CreateSellerDao();

        Scanner sc = new Scanner(System.in);

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


        System.out.println("\n=== Tetes 5: Seller Update =====");
        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println("\n=== Tetes 6: Seller Delete =====");
        System.out.println("Enter id for delete test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete Completed");

        sc.close();

        */
    }
}