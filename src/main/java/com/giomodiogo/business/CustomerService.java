package com.giomodiogo.business;

import com.giomodiogo.dao.CustomerDAO;
import com.giomodiogo.dao.ICustomerDAO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerService implements ICustomerService {

    private ICustomerDAO dao;

    @Override
    public List<String> list() {
        return dao.list();
    }

    @Override
    public List<String> getByName(String name) {
        List<String> customers = dao.list();
        return customers.stream().filter(c -> c.contains(name)).collect(Collectors.toList());
    }

    @Override
    public UUID save(String name) {
        return dao.save(name);
    }
}
