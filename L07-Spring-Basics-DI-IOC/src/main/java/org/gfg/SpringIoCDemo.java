package org.gfg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("projectbeans.xml");

        Engine engine1 = applicationContext.getBean("engine1", Engine.class);
        System.out.println(engine1);

        Engine engine2 = applicationContext.getBean("engine1", Engine.class);
        System.out.println(engine1);

        System.out.println(engine1 == engine2);

        Car car1 = applicationContext.getBean("car1", Car.class);
        car1.runCar();


        Engine engine2A = applicationContext.getBean("engine2", Engine.class);
        System.out.println(engine2A);
        Engine engine2B = applicationContext.getBean("engine2", Engine.class);
        System.out.println(engine2A);
        System.out.println(engine2A == engine2B);

        Engine engine3 = applicationContext.getBean("engine3", Engine.class);
        System.out.println(engine3);

        applicationContext.close();
    }
}
