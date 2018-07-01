package com.kymjs.kotlinprimer

import com.kymjs.kotlinprimer.A.format


fun main(args: Array<String>) {
    function("")
}


fun function(str: String) {
    val fmt1 = format(str)
//    println(fmt1.length)
//    val fmt2: String = format(str)
    val fmt3: String? = format(str)
    println(fmt3?.length)
    
}
