package org.wjanaszek.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.wjanaszek.model.Fruit;
import org.wjanaszek.repositories.FruitRepository;

import java.math.BigDecimal;

@Component
public class FruitLoader implements ApplicationListener<ContextRefreshedEvent> {

    private FruitRepository fruitRepository;

    private Logger logger = Logger.getLogger(FruitLoader.class);

    @Autowired
    public void setFruitRepository(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Fruit mango = new Fruit();
        mango.setDescription("Very good mangooo");
        mango.setPrice(new BigDecimal("3.99"));
        mango.setImageUrl("http://www.polishweeklychicago.com/wp-content/uploads/2015/06/Mango-Image-free-3.jpg");
        mango.setFruitId("1111111");
        fruitRepository.save(mango);

        logger.info("Saved mango - id: " + mango.getId());

        Fruit apple = new Fruit();
        apple.setDescription("Very red and good apple");
        apple.setPrice(new BigDecimal("2.12"));
        apple.setImageUrl("http://szlachetnezdrowienet.pl/wp-content/uploads/2015/05/jab%C5%82ko-300x300.jpg");
        apple.setFruitId("222222");
        fruitRepository.save(apple);

        logger.info("Saved apple - id: " + apple.getId());
    }
}
