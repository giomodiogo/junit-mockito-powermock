package com.giomodiogo.dao;

import java.util.List;
import java.util.UUID;

public class CustomerDAO implements ICustomerDAO{

    @Override
    public List<String> list() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public UUID save(String name) {
        return null;
    }
}
