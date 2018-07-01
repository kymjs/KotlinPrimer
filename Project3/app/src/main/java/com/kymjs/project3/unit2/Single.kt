package com.kymjs.project3.unit2

/**
 * Created by ZhangTao on 18/6/13.
 */

class Single private constructor() {
    companion object {
        init {
            
        }
        
        fun get(): Single {
            return Holder.instance
        }
    }

    private object Holder {
        init {
            println("holder")
        }

        val instance = Single()
    }
}

fun main(args: Array<String>) {
    Single.get()
}

