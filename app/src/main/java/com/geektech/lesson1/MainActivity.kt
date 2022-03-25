package com.geektech.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.lesson1.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
    private lateinit var registerActivity: ActivityResultLauncher<Intent>

    companion object {
        const val KEY = "text"
        const val KEY2 = "text2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){activityResult ->
            binding.etNext.setText(activityResult.data?.getStringExtra(KEY2))
        }

        binding.btnNext.setOnClickListener {
            if (binding.etNext.text.toString().isNotEmpty())
                Intent(this, MainActivity2::class.java).apply {
               putExtra(KEY, binding.etNext.text.toString())
               registerActivity.launch(this)
           } else {
                Toast.makeText(this, getString(R.string.toast_1), Toast.LENGTH_SHORT).show()
            }
        }
    }
}

