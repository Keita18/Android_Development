package com.example.studenttimemanagement.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenttimemanagement.databinding.FragmentItemKnowledgeBinding
import com.example.studenttimemanagement.model.Knowledge

class KnowledgeAdapter(
    private val knowledges: List<Knowledge>,
    private val listener: KnowledgeClickListener
) : RecyclerView.Adapter<KnowledgeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val knowledge = knowledges[position]
        holder.bind(knowledge, listener)
    }

    override fun getItemCount(): Int = knowledges.size

    class ViewHolder private constructor(val binding: FragmentItemKnowledgeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(knowledge: Knowledge, listener: KnowledgeClickListener) {
            binding.knowledge = knowledge
            binding.listener = listener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {

                val inflater = LayoutInflater.from(parent.context)
                val binding: FragmentItemKnowledgeBinding =
                    FragmentItemKnowledgeBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class KnowledgeClickListener(val listener: (knowledge: Knowledge) -> Unit) {
    fun onClick(knowledge: Knowledge) = listener(knowledge)
}