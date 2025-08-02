package com.cust.service;

import com.cust.model.Customer;
import com.cust.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerRewardServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerRewardServiceImpl rewardService;

    @Test
    void shouldUpdateRewardPointsWhenCustomerExists() {

        Customer customer = new Customer
                ("cust_001", "Arun", "arun@example.com", "9783896562", 100.00);
        when(customerRepository.findById("cust_001")).thenReturn(Optional.of(customer));

        rewardService.updateReward("cust_001", 500.00);

        assertEquals(150, customer.getRewardPoints());
        verify(customerRepository).save(customer);
    }


        @Test
        void shouldThrowExceptionWhenCustomerNotFound() {
            when(customerRepository.findById(anyString())).thenReturn(Optional.empty());

            assertThrows(IllegalArgumentException.class, () -> rewardService.updateReward("cust_002", 300.0));
        }
}