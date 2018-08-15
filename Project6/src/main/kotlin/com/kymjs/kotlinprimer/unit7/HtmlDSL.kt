package com.kymjs.kotlinprimer.unit7

import java.io.File

fun main(args: Array<String>) {
    val result =
            html {
                head {
                    title {
                        "HTML encoding with Kotlin"()
                    }
                }
                body {
                    h1 { "HTML encoding with Kotlin"{} }
                    p { "this format can be used as an alternative markup to HTML"{} }

                    a(href = "http://jetbrains.com/kotlin") { "Kotlin"{} }

                    p {
                        "This is some"{
                            "color" `=` "red"
                        }
                        b {
                            "mixed"{
                                "color" `=` "blue"
                            }
                        }
                        "text. For more see the"{}
                        a(href = "http://jetbrains.com/kotlin") {
                            "Kotlin"{
                                "color" `=` "green"
                            }
                        }
                        "project"{
                            "color" `=` "#ff00ff"
                        }
                    }
                    p { "some text"{} }

                    p {
                        "Command line arguments were:"{}
                        ul {
                            for (arg in args)
                                li { arg {} }
                        }
                    }
                }
            }
    val htmlFile = File("test.html")
    htmlFile.takeIf { it.exists() }?.delete()
    htmlFile.writeText(result.toString())
}

interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

abstract class Tag(val name: String) : Element {
    val children = arrayListOf<Element>()
    val attributes = hashMapOf<String, String>()

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$name${renderAttributes()}>\n")
        for (c in children) {
            c.render(builder, indent + "  ")
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttributes(): String? {
        val builder = StringBuilder()
        for (a in attributes.keys) {
            builder.append(" $a=\"${attributes[a]}\"")
        }
        return builder.toString()
    }


    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    val textAttributes = hashMapOf<String, String>()

    operator fun String.invoke() {
        children.add(TextElement(this))
    }

    operator fun String.invoke(block: () -> Unit) {
        block.invoke()
        if (textAttributes.isEmpty()) {
            children.add(TextElement(this))
        } else {
            children.add(FONT(this, textAttributes))
        }
    }

    infix fun String.`=`(value: String) {
        textAttributes.put(this, value)
    }

//    operator fun String.minus(value: String) {
//        textAttributes.put(this, value)
//    }
}

class HTML() : TagWithText("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)

    fun body(init: Body.() -> Unit) = initTag(Body(), init)
}

class Head() : TagWithText("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init)
}

class Title() : TagWithText("title")

abstract class BodyTag(name: String) : TagWithText(name) {
    fun b(init: B.() -> Unit) = initTag(B(), init)
    fun p(init: P.() -> Unit) = initTag(P(), init)
    fun h1(init: H1.() -> Unit) = initTag(H1(), init)
    fun ul(init: UL.() -> Unit) = initTag(UL(), init)
    fun a(href: String, init: A.() -> Unit) {
        val a = initTag(A(), init)
        a.href = href
    }
}

class Body() : BodyTag("body")
class UL() : BodyTag("ul") {
    fun li(init: LI.() -> Unit) = initTag(LI(), init)
}

class B() : BodyTag("b")
class LI() : BodyTag("li")
class P() : BodyTag("p")
class H1() : BodyTag("h1")

class A() : BodyTag("a") {
    public var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

class FONT(text: String, textAttributes: HashMap<String, String>) : BodyTag("font") {
    init {
        attributes.putAll(textAttributes)
        children.add(TextElement(text))
    }
}