package com.java8.lambda.main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class DataGenerators {

    public static List<String> stringGenerator(long size){
        return Stream.generate(()-> RandomStringUtils.randomAlphabetic(25)).limit(size).collect(Collectors.toList());
    }
}