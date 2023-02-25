package dev.seabat.android.hellochatgpt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.seabat.android.hellochatgpt.databinding.ActivityMainBinding
import dev.seabat.android.hellochatgpt.ui.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textInputEditQuery.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                if (binding.textInputEditQuery.text.toString().isNotEmpty()) {
                    binding.textResponse.text = getString(R.string.please_wait)
                    viewModel.sendMessage(binding.textInputEditQuery.text.toString())
                } else {
                    Toast.makeText(this, getString(R.string.please_enter_query), Toast.LENGTH_SHORT).show()
                }
                return@OnEditorActionListener true
            }
            false
        })

        viewModel.response.observe(this, Observer {
            if (it !== null) {
                binding.textResponse.text = binding.textInputEditQuery.text.toString() + it
            }else{
                Toast.makeText(this, getString(R.string.please_retry), Toast.LENGTH_SHORT).show()
            }
        })
    }
}