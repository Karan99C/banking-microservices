package com.cust.service;

import com.cust.model.Customer;
import com.cust.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerServiceImpl service;

    public CustomerServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void createCustomer() {
        Customer customer = new Customer
                ("cust_001", "Arun", "arun@example.com","9783896562",100.00);
        when(repository.save(customer)).thenReturn(customer);

        Customer result = service.createCustomer(customer);
        assertEquals("Arun",result.getName());
        verify(repository).save(customer);


    }

    @Test
    void getCustomerById() {
        Customer customer = new Customer
                ("cust_001", "Arun", "arun@example.com","9783896562",300.00);
        when(repository.findById("cust_001")).thenReturn(Optional.of(customer));

        Customer result= service.getCustomerById("cust_001");
        assertNotNull(result);
        assertEquals("Arun",result.getName());

    }

    @Test
    void getAllCustomers() {
        List<Customer> customers= List.of(
                new Customer("cust_001", "Arun", "a@x.com","6573575254",100.00),
                new Customer("cust_002", "Priya", "p@x.com","6564572242",300.00)

        );

        when(repository.findAll()).thenReturn(customers);

        List<Customer> list= service.getAllCustomers();
        assertEquals(2,list.size());
    }
}