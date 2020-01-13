package com.tuktukhop.audio.aadcpreparation.samples.koin

import android.app.Application
import androidx.lifecycle.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject
import org.koin.dsl.module
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.dsl.viewModel


interface HelloRepository {
    fun hello(): String
}

class HolaRepository : HelloRepository{
    override fun hello() = "HOLA Koin!"
}

class HelloRepositoryImpl : HelloRepository {
    override fun hello() = "Hello Koin"
}

class MySimplePresenter(val repo: HelloRepository){
    fun sayHello() = repo.hello()
}

class HelloApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@HelloApplication)
            modules(secondAppModule)
        }
    }
}

class HelloViewModel(val repo: HelloRepository) : ViewModel(){
    fun sayHello() = repo.hello()
}

val secondAppModule = module {
    single<HelloRepository> { HolaRepository() }
    factory { MySimplePresenter(get()) }
    viewModel { HelloViewModel(get()) }
}

val appModule = module {
    //single instance
    single<HelloRepository> {HelloRepositoryImpl()}

    //factory = create new instance each time activity needs one
    factory { MySimplePresenter(get()) }
}