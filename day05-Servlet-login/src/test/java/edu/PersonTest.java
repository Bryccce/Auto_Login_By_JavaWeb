package edu;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void test01(){
        Person person = new Person();
        person.setName("n");
        System.out.println(person.getName());
    }
}