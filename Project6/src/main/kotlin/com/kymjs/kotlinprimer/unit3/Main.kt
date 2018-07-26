package com.kymjs.kotlinprimer.unit3


data class User(var name: String)

fun main(args: Array<String>) {

    val user = User("ZhangTao")

    //let与run都会返回闭包的执行结果，区别在于let有闭包参数，而run没有闭包参数
    val letResult = user.let { "let::${it.javaClass}" }
    println(letResult)
    val runResult = user.run { "run::${this.javaClass}" }
    println(runResult)

    //also与apply都不返回闭包的执行结果，区别在于also有闭包参数，而apply没有闭包参数
    user.also {
        println("also::${it.javaClass}")
    }.apply {
        println("apply::${this.javaClass}")
    }.name = "hello"

    //takeIf 的闭包返回一个判断结果，为false时，takeIf函数会返回空
    //takeUnless 与 takeIf 刚好相反， 闭包的判断结果，为true时函数会返回空
    user.takeIf { it.name.length > 0 }?.also { println("姓名为${it.name}") } ?: println("姓名为空")
    user.takeUnless { it.name.length > 0 }?.also { println("姓名为空") } ?: println("姓名为${user.name}")

    //重复执行当前闭包
    repeat(5) {
        println(user.name)
        print(it)
    }

    //with比较特殊，不是以扩展方法的形式存在的，而是一个顶级函数
    with(user) {
        this.name = "with"
    }
    
//    user.apply{ this.name = "with"}

}