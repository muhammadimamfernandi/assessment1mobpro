package org.d3if2041.hitungkecepatan.ui.histori

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if2041.hitungkecepatan.databinding.FragmentHistoriKecepatanBinding
import org.d3if2041.hitungkecepatan.db.KecepatanDb
import org.d3if2041.hitungkecepatan.ui.kecepatan.KecepatanViewModelFactory

class HistoriKecepatanFragment : Fragment() {

    private val viewModel: KecepatanHistoriViewModel by lazy {
        val db = KecepatanDb.getInstance(requireContext())
        val factory = KecepatanViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[KecepatanHistoriViewModel::class.java]
    }

    private lateinit var binding: FragmentHistoriKecepatanBinding
    private lateinit var myAdapter: KecepatanAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoriKecepatanBinding.inflate(layoutInflater, container,
            false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myAdapter = KecepatanAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }

        viewModel.data.observe(viewLifecycleOwner, { myAdapter.submitList(it) })
    }

}