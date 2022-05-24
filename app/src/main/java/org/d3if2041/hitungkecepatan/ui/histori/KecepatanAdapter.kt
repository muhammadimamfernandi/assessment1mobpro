package org.d3if2041.hitungkecepatan.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.d3if2041.hitungkecepatan.R
import org.d3if2041.hitungkecepatan.databinding.HistoriKecepatanBinding
import org.d3if2041.hitungkecepatan.db.KecepatanEntity
import org.d3if2041.hitungkecepatan.model.hitungKecepatan
import java.text.SimpleDateFormat
import java.util.*

class KecepatanAdapter :
    ListAdapter<KecepatanEntity, KecepatanAdapter.ViewHolder>(DIFF_CALLBACK) {

        companion object {
            private val DIFF_CALLBACK =
                object : DiffUtil.ItemCallback<KecepatanEntity>() {
                    override fun areItemsTheSame(
                        oldItem: KecepatanEntity,
                        newItem: KecepatanEntity
                    ): Boolean {
                        return oldItem.id == newItem.id
                    }

                    override fun areContentsTheSame(
                        oldItem: KecepatanEntity,
                        newItem: KecepatanEntity
                    ): Boolean {
                        return oldItem == newItem
                    }
                }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HistoriKecepatanBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: HistoriKecepatanBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
        Locale("id", "ID"))

        fun bind(item: KecepatanEntity) = with(binding) {
            val hasilKecepatan = item.hitungKecepatan()

            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            kecepatanTextView.text = root.context.getString(R.string.hasil_kecepatan,
                hasilKecepatan.kecepatan)

            dataTextView.text = root.context.getString(R.string.data_kecepatan, item.jarak,
                item.waktu)
        }
    }
}