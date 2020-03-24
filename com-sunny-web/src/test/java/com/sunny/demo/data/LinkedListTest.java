package com.sunny.demo.data;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author dongyangz
 * @date 2020-03-24 18:15
 */
public class LinkedListTest {

    //反向遍历链表
    public static void main(String[] args) {
        LinkedList<Integer> list = Lists.newLinkedList();
        list.add(1);
        list.add(11);
        list.add(1111);
        list.add(22);
        list.add(23);
        show(list);


        Stack<Integer> stack = new Stack<>();
        for (Integer o : list) {
            stack.push(o);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }


    }

    public static void show(LinkedList<Integer> list) {
//        for (Integer o : list) {
//            System.out.println(o);
//        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
