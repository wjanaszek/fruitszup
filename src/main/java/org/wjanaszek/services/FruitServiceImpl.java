package org.wjanaszek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wjanaszek.model.Fruit;
import org.wjanaszek.repositories.FruitRepository;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public void setFruitRepository(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Iterable<Fruit> listAllFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getFruitById(Integer id) {
        return fruitRepository.findOne(id);
    }

    @Override
    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(Integer id) {
        fruitRepository.delete(id);
    }
}
