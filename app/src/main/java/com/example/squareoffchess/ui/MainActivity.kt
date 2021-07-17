package com.example.squareoffchess.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squareoffchess.R
import com.example.squareoffchess.databinding.ActivityMainBinding
import com.example.squareoffchess.utils.MyViewModelFactory
import com.example.squareoffchess.utils.NetworkStateHelper
import com.example.squareoffchess.utils.Repository
import com.example.squareoffchess.utils.RetrofitHelper
import com.example.squareoffchess.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    private val repository by lazy { Repository(RetrofitHelper.getServiceInstance()) }
    private val viewModel by lazy {
        ViewModelProvider(this, MyViewModelFactory(repository)).get(
            MainViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.inflate<ActivityMainBinding>(
            layoutInflater,
            R.layout.activity_main,
            null,
            false
        ).apply {
            lifecycleOwner = this@MainActivity
            viewmodel = viewModel
        }.also { binding ->
            setContentView(binding.root)
        }

        NetworkStateHelper(this).observe(this, {
            it?.let {
                viewModel.isOnline.postValue(it)
            }
        })
    }
}