package org.wjanaszek.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wjanaszek.model.Fruit;

public interface FruitRepository extends CrudRepository<Fruit, Integer> {

}
