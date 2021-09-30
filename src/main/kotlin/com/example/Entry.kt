package com.example

import kotlinx.coroutines.*
import kotlin.coroutines.*

fun main() = runBlocking { //1

//    println(this) //2
//    println(this.coroutineContext) //3
//    println("ContinuationInterceptor: ${this.coroutineContext[ContinuationInterceptor]}") //4
//
//    launch { //5
//        doBlocking()
//    }
//
//    this.launch(
//        EmptyCoroutineContext, // 6
//        CoroutineStart.DEFAULT,
//        { doBlocking() }
//    )
//
//    launch(Dispatchers.Default){ //7
//        doBlocking()
//    }

//    repeat(20){ //8
//        launch(Dispatchers.IO){
//            doIO()
//        }
//    }

    repeat(20){ //9
        launch(Dispatchers.Default){
            doBlocking()
        }
    }   

    println()
}

suspend fun doBlocking() { //10
    println("start doBlocking task in thread: ${Thread.currentThread().name}") //11
    delay(2000L) //12
    println("end doBlocking task in thread: ${Thread.currentThread().name}") //13
}

suspend fun doIO(){ //14
    //Pretend that we are doing some blocking IO task.
    println("start IO task in thread: ${Thread.currentThread().name}") //15
    delay(2000L) //15
    println("end IO task in thread: ${Thread.currentThread().name}") //16
}