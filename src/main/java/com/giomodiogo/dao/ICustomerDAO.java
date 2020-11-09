package com.giomodiogo.dao;

import java.util.List;
import java.util.UUID;

public interface ICustomerDAO {

    List<String> list();

    UUID save(String name);
}
