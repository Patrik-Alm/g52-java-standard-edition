package se.lexicon;

import se.lexicon.data.CustomerDao;
import se.lexicon.impl.CustomerDaoImpl;
import se.lexicon.model.Customer;

public class Main {
    public static void main(String[] args) {



        // Single Source of Truth
        CustomerDao customerDao = CustomerDaoImpl.getInstance();

        customerDao.create(new Customer(1,"Mattias Karlsson"
                ,"0701234556", "mattias@karlsson.mk"));

        customerDao.create(new Customer(2,"Ulrika Karlsson"
                ,"0701234567", "Ulrika@karlsson.mk"));

        System.out.println(customerDao.findAll().size()); // 2



        //All the same Object, same memory address, only created ones.
        CustomerDao customerDao1 = CustomerDaoImpl.getInstance();
        customerDao1 = CustomerDaoImpl.getInstance();
        customerDao1 = CustomerDaoImpl.getInstance();
        customerDao1 = CustomerDaoImpl.getInstance();
        customerDao1 = CustomerDaoImpl.getInstance();
        customerDao1 = CustomerDaoImpl.getInstance();
        customerDao1 = CustomerDaoImpl.getInstance();

        System.out.println(customerDao1.findAll().size()); //2








    }
}