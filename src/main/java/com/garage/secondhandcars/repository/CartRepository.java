package com.garage.secondhandcars.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.garage.secondhandcars.dao.CartDao;

@Repository
public interface CartRepository extends CrudRepository<CartDao, Integer> {

}
