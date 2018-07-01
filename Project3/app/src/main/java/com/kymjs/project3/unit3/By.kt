package com.kymjs.project3.unit3

/**
 * Created by ZhangTao on 18/6/13.
 */

interface Animal {
    fun bark()
}

class Dog : Animal {
    override fun bark() {
        println("Wang")
    }
}

class Zoo(animal: Animal) : Animal by animal {
    override fun bark() {
        println("zoo")
    }
}

fun main(args: Array<String>) {
    Zoo(Dog()).bark()
}
