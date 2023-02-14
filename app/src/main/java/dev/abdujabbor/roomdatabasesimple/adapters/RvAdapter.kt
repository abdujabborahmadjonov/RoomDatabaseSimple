package dev.abdujabbor.roomdatabasesimple.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.abdujabbor.roomdatabasesimple.databinding.MyRvItemBinding
import dev.abdujabbor.roomdatabasesimple.models.Manager

class RvAdapter(var list: ArrayList<Manager>) :
    RecyclerView.Adapter<RvAdapter.VH>() {
    inner class VH(var itemViewBinding: MyRvItemBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(list: Manager, position: Int) {
            itemViewBinding.name.text = list.name
            itemViewBinding.number.text = list.number

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        return VH(MyRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
