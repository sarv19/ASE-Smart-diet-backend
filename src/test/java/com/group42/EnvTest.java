package com.group42;

/**
 * EnvTest
 *
 * @author Guofeng Lin
 * @since 2023/2/11
 */
public class EnvTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.getProperties().forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
