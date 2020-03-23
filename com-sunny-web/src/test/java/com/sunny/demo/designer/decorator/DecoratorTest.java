package com.sunny.demo.designer.decorator;

/**
 * 装饰器模式初体验
 *
 * @author dongyangz
 * @date 2020-03-23 18:03
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Fruit fruit1 = new Apple();
        System.out.println(fruit1.name());

        Fruit fruit2 = new Banana();
        System.out.println(fruit2.name());

        new People(fruit1).eat();
        new People(fruit2).eat();
    }
}
