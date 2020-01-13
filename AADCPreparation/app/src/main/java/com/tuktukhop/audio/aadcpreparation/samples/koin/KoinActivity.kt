package com.tuktukhop.audio.aadcpreparation.samples.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tuktukhop.audio.aadcpreparation.R
import com.tuktukhop.audio.aadcpreparation.samples.showToast
import kotlinx.android.synthetic.main.activity_koin.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class KoinActivity : AppCompatActivity() {

    val firstPresenter : MySimplePresenter by inject()
    val vm : HelloViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin)

        showToast(this, vm.sayHello())
        textView.text = vm.sayHello()
    }
}
