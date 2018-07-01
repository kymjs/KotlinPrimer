package com.kymjs.project2.unit2;

/**
 * Created by ZhangTao on 18/6/10.
 */
public class Java {

    public static final String name(Animal receiver){
        return "animal";
    }
    public static final String name(Dog receiver){
        return "dog";
    }

    public static final void printName(Animal receiver, Animal anim){
        String str = name(anim);
        System.out.println(str);
    }

    public static final void main(String[] args){
        printName((Animal)new Dog(), (Animal)new Dog());
    }
}
