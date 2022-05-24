package org.d3if2041.hitungkecepatan.ui.kecepatan

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.ListAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if2041.hitungkecepatan.R
import org.d3if2041.hitungkecepatan.databinding.FragmentKecepatanBinding
import org.d3if2041.hitungkecepatan.db.KecepatanDb
import org.d3if2041.hitungkecepatan.model.HasilKecepatan
import org.d3if2041.hitungkecepatan.ui.histori.KecepatanAdapter

class KecepatanFragment : Fragment() {

    private lateinit var binding: FragmentKecepatanBinding
    private lateinit var myAdapter: KecepatanAdapter

    private val viewModel: KecepatanViewModel by lazy {
        val db = KecepatanDb.getInstance(requireContext())
        val factory = KecepatanViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[KecepatanViewModel::class.java]
    }

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
        viewModel.getHasilKecepatan().observe(requireActivity(), { showResult(it) })
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.histori_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_histori) {
//            findNavController().navigate(
//                R.id.action_kecepatanFragment4_to_historiKecepatanFragment)
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }

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

        viewModel.hitungKecepatan(jarak.toFloat(), waktu.toFloat())
    }

    private fun showResult(result: HasilKecepatan?) {
        if (result == null) return
        binding.hasilTextView.text = getString(R.string.hasil, result.kecepatan.toString())
    }

    private fun reset() {
        binding.jarakTempuhInp.text = null
        binding.waktuTempuhInp.text = null

        binding.hasilTextView.text = null
    }
}