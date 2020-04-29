package com.kingmao.dynamic;

import com.kingmao.dynamic.apple.entity.Apple;
import com.kingmao.dynamic.apple.service.AppleService;
import com.kingmao.dynamic.peach.entity.Peach;
import com.kingmao.dynamic.peach.service.PeachService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootDynamicApplicationTests {
    @Autowired
    private AppleService appleService;
    @Autowired
    private PeachService peachService;

    @Test
    public void t1() {
        for (int x = 0;  x < 10;x++) {
            List<Apple> all = appleService.getAll();
            all.forEach(in-> System.out.println(in.getName()));

            List<Peach> all1 = peachService.getAll();
            all1.forEach(in-> System.out.println(in.getName()));
        }
    }

    @Test
    public void t2(){
        Apple apple = new Apple();
        apple.setColor("sd");
        apple.setWeight(new BigDecimal(12));
        apple.setName("插入3306apple6");
        appleService.save(apple);

        Apple apple2 = new Apple();
        apple2.setColor("sd");
        apple2.setWeight(new BigDecimal(12));
        apple2.setName("插入3306apple7");
        appleService.save(apple2);

        Peach peach = new Peach();
        peach.setColor("sd");
        peach.setWeight(new BigDecimal(12));
        peach.setName("插入3306peach1");
        peachService.insert(peach);

        Peach peach1 = new Peach();
        peach1.setColor("sd");
        peach1.setWeight(new BigDecimal(12));
        peach1.setName("插入3306peach2");
        peachService.insert(peach1);



    }

}
