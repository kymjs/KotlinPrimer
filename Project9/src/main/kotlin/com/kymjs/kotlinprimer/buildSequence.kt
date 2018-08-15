package com.kymjs.kotlinprimer

import kotlin.coroutines.experimental.*

interface SequenceBuilder<in T> {
    suspend fun yield(value: T)
}

fun <T> buildSequence(block: suspend SequenceBuilder<T>.() -> Unit): Sequence<T> = Sequence {
    MyCoroutine<T>().apply {
        nextStep = block.createCoroutine(receiver = this, completion = this)
    }
}

private class MyCoroutine<T> : AbstractIterator<T>(), SequenceBuilder<T>, Continuation<Unit> {

    lateinit var nextStep: Continuation<Unit>
    override val context: CoroutineContext get() = EmptyCoroutineContext

    override fun computeNext() { nextStep.resume(Unit) }

    override fun resume(value: Unit) { done() }
    override fun resumeWithException(exception: Throwable) { throw exception }

    override suspend fun yield(value: T) {
        setNext(value)
        return suspendCoroutine { cont -> nextStep = cont }
    }
}
