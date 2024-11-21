package se.lexicon.data;

import se.lexicon.model.Customer;

import java.util.Collection;

public interface CustomerDao {
    Customer create(Customer customer);

    Customer findById(int id);

    Customer findByReservationId(int rid);

    boolean removeById(int id);

    Collection<Customer> findAll();
}
