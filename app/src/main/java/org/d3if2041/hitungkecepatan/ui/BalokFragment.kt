package org.d3if2041.hitungkecepatan.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if2041.hitungkecepatan.BalokViewModel
import org.d3if2041.hitungkecepatan.KecepatanViewModel
import org.d3if2041.hitungkecepatan.R
import org.d3if2041.hitungkecepatan.databinding.FragmentBalokBinding
import org.d3if2041.hitungkecepatan.model.HasilBalok

class BalokFragment : Fragment() {

    private lateinit var binding: FragmentBalokBinding

    private val viewModel: BalokViewModel by lazy {
        ViewModelProvider(requireActivity())[BalokViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBalokBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { volume() }
        binding.resetButton.setOnClickListener { reset() }
        viewModel.getHasilBalok().observe(requireActivity(), { showResult(it) })
    }

    private fun volume() {
        val panjang = binding.panjangInp.text.toString()
        if (TextUtils.isEmpty(panjang)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val lebar = binding.lebarInp.text.toString()
        if (TextUtils.isEmpty(lebar)) {
            Toast.makeText(context, R.string.lebar_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.tinggiInp.text.toString()
        if (TextUtils.isEmpty(tinggi)) {
            Toast.makeText(context, R.string.tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }

        viewModel.hitungVolumeBalok(panjang.toFloat(), lebar.toFloat(),
            tinggi.toFloat())
    }

    private fun showResult(result: HasilBalok?) {
        if (result == null) return
        binding.hasilTextView.text = getString(R.string.hasil_balok, result.volume.toString())
    }

    private fun reset() {
        binding.panjangInp.text = null
        binding.lebarInp.text = null
        binding.tinggiInp.text = null

        binding.hasilTextView.text = null
    }
}