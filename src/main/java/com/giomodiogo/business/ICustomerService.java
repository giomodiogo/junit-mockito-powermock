package com.giomodiogo.business;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {

    List<String> list();

    List<String> getByName(String name);

    UUID save(String name);
}
