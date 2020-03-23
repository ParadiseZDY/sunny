package com.sunny.demo.designer.decorator;

/**
 * 香蕉
 *
 * @author dongyangz
 * @date 2020-03-23 17:53
 */
public class Banana extends Fruit {

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

}
