package org.d3if2041.hitungkecepatan.ui.histori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if2041.hitungkecepatan.databinding.FragmentHistoriBalokBinding
import org.d3if2041.hitungkecepatan.db.BalokDb

class HistoriBalokFragment : Fragment() {

    private val viewModel: BalokHistoriViewModel by lazy {
        val db = BalokDb.getInstance(requireContext())
        val factory = BalokHistoriViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[BalokHistoriViewModel::class.java]
    }

    private lateinit var binding: FragmentHistoriBalokBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoriBalokBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}