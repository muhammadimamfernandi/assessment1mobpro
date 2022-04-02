package org.d3if2041.hitungkecepatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2041.hitungkecepatan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { kecepatan() }
        binding.resetButton.setOnClickListener { reset() }
    }

    private fun kecepatan() {
        val jarak = binding.jarakTempuhInp.text.toString()
        if (TextUtils.isEmpty(jarak)) {
            Toast.makeText(this, R.string.jarak_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val waktu = binding.waktuTempuhInp.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(this, R.string.waktu_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val kecepatan = jarak.toFloat() / waktu.toFloat();
        binding.hasilTextView.text = getString(R.string.hasil, kecepatan)
    }

    private fun reset() {
        binding.jarakTempuhInp.text = null
        binding.waktuTempuhInp.text = null

        binding.hasilTextView.text = null
    }
}