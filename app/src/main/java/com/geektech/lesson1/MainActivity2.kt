package com.geektech.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.lesson1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etSave.setText(intent.getStringExtra(MainActivity.KEY))
        binding.btnCliker.setOnClickListener {
            if (binding.etSave.text.isNotEmpty()) {
                setResult(
                    RESULT_OK,
                    Intent().putExtra(MainActivity.KEY2, binding.etSave.text.toString())
                )
                finish()
            } else {
                Toast.makeText(this,getString(R.string.toast_1),Toast.LENGTH_SHORT).show()
            }
        }
    }
}