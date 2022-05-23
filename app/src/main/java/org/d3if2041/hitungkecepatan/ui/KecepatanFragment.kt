package org.d3if2041.hitungkecepatan.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.d3if2041.hitungkecepatan.R
import org.d3if2041.hitungkecepatan.databinding.FragmentKecepatanBinding

class KecepatanFragment : Fragment() {

    private lateinit var binding: FragmentKecepatanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKecepatanBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { kecepatan() }
        binding.resetButton.setOnClickListener { reset() }
    }

    private fun kecepatan() {
        val jarak = binding.jarakTempuhInp.text.toString()
        if (TextUtils.isEmpty(jarak)) {
            Toast.makeText(context, R.string.jarak_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val waktu = binding.waktuTempuhInp.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(context, R.string.waktu_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val kecepatan = jarak.toFloat() / waktu.toFloat();
        binding.hasilTextView.text = getString(R.string.hasil, kecepatan.toString())
    }

    private fun reset() {
        binding.jarakTempuhInp.text = null
        binding.waktuTempuhInp.text = null

        binding.hasilTextView.text = null
    }
}