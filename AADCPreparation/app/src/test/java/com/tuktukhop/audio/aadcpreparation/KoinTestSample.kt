package com.tuktukhop.audio.aadcpreparation

import com.tuktukhop.audio.aadcpreparation.samples.koin.HelloViewModel
import com.tuktukhop.audio.aadcpreparation.samples.koin.MySimplePresenter
import com.tuktukhop.audio.aadcpreparation.samples.koin.secondAppModule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class KoinTestSample : KoinTest {
    val presenter : MySimplePresenter by inject()

    @Test
    fun myTest(){
        startKoin { modules(secondAppModule) }
    }
}