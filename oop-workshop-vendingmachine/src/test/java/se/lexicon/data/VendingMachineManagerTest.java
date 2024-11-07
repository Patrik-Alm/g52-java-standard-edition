package se.lexicon.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Beverage;
import se.lexicon.model.Fruit;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineManagerTest {

    private Product[] products;
    private VendingMachineManager vendingMachine;

    @BeforeEach
    void setUp() {
        products = new Product[] {
                new Snack(1, 1.5, "Chips"),
                new Fruit(2, "Apple", "Red", 0.75),
                new Beverage(3, "Soda", false, 40, 2.0)
        };
        vendingMachine = new VendingMachineManager(products);
    }

    @Test
    void testAddCurrency() {
        vendingMachine.addCurrency(10);
        assertEquals(10, vendingMachine.getBalance());
    }

    @Test
    void testGetBalance() {
        vendingMachine.addCurrency(5);
        vendingMachine.addCurrency(20);
        assertEquals(25, vendingMachine.getBalance());
    }

    @Test
    void testRequestSuccessful() {
        vendingMachine.addCurrency(5);
        Product requestedProduct = vendingMachine.request(2);
        assertNotNull(requestedProduct);
    }

    @Test
    void testRequestInsufficientBalance() {
        vendingMachine.addCurrency(1);
        assertThrows(RuntimeException.class, () -> vendingMachine.request(3));
    }

    @Test
    void testRequestProductNotFound() {
        vendingMachine.addCurrency(10);
        assertThrows(RuntimeException.class, () -> vendingMachine.request(5));
    }

    @Test
    void testEndSession() {
        vendingMachine.addCurrency(5);
        vendingMachine.endSession();
        assertEquals(0, vendingMachine.getBalance());
    }

    @Test
    void testGetDescriptionProductFound() {
        String description = vendingMachine.getDescription(1);
        assertTrue(description.contains("id: 1"));
    }

    @Test
    void testGetDescriptionProductNotFound() {
        String description = vendingMachine.getDescription(5);
        assertTrue(description.contains("Could not find product with id 5"));
    }

    @Test
    void testGetProducts() {
        String[] productDescriptions = vendingMachine.getProducts();
        assertEquals(products.length, productDescriptions.length);
    }
}