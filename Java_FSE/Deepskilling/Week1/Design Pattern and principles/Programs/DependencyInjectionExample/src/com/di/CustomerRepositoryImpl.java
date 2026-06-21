package com.di;

public class CustomerRepositoryImpl
        implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        if(id == 101) {
            return "John";
        }
        else if(id == 102) {
            return "David";
        }

        return "Customer Not Found";
    }
}