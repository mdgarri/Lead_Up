package com.art_int_labs.lead_up.data.internal

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}