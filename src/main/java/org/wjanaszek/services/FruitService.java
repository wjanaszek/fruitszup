package org.wjanaszek.services;

import org.wjanaszek.model.Fruit;

public interface FruitService {

    Iterable<Fruit> listAllFruits();

    Fruit getFruitById(Integer id);

    Fruit saveFruit(Fruit fruit);

    void deleteFruit(Integer id);
}
