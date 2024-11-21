package se.lexicon.impl;

import se.lexicon.data.CustomerDao;
import se.lexicon.model.Customer;

import java.util.*;

public class CustomerDaoImpl implements CustomerDao {

    private final List<Customer> storage;

    private static CustomerDaoImpl instance;

    /*           https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm            */
    public static CustomerDaoImpl getInstance(){
        if (instance == null){
            instance = new CustomerDaoImpl();
        }
        return instance;
    }

    private CustomerDaoImpl() {
        this.storage = new ArrayList<>();
    }

    @Override
    public Customer create(Customer customer) {

        if (customer == null) throw new IllegalArgumentException("Customer was null!");
        if (storage.contains(customer)) throw new IllegalArgumentException("Customer already exists");

        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(int id) {
        for (Customer c:storage){
            if (c.getId() == id){
                return Optional.of(c);
            }
        }
        return Optional.empty();

    }

    @Override
    public Customer findByReservationId(int rid) {

        for (Customer c : storage){
            if (c.getReservation() == null){
                continue;
            }

            if (c.getReservation().getId() == rid){
                return c;
            }
        }


        return null;
    }

    @Override
    public boolean removeById(int id) {
        Optional<Customer> customer = findById(id);

        if (customer.isPresent()){
            return storage.remove(customer.get());
        }

        return false;
    }

    @Override
    public Collection<Customer> findAll() {
        return Collections.unmodifiableCollection(storage);
    }
}
