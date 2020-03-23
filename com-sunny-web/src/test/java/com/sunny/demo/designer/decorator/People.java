package com.sunny.demo.designer.decorator;

/**
 * 装饰器
 *
 * @author dongyangz
 * @date 2020-03-23 17:55
 */
public class People {

    private Fruit fruit;

    public People(Fruit fruit) {
        this.fruit = fruit;
    }

    public void eat() {
        System.out.println("我吃的水果是:" + fruit.name());
    }
}
