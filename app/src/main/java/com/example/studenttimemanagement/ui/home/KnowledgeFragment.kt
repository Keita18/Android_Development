package com.example.studenttimemanagement.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.studenttimemanagement.R
import com.example.studenttimemanagement.databinding.FragmentKnowledgeListBinding

/**
 * A fragment representing a list of Items.
 */
class KnowledgeFragment : Fragment() {
    private lateinit var binding:FragmentKnowledgeListBinding

    private lateinit var viewModel: KnowledgeViewModel
    private  lateinit var adapter: KnowledgeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_knowledge_list, container, false)
        viewModel = ViewModelProvider(this).get(KnowledgeViewModel::class.java)
        viewModel.knowledges.observe(viewLifecycleOwner, Observer {
            it?.let {
               adapter = KnowledgeAdapter(it, KnowledgeClickListener { knowledge -> viewModel.onNavigateToSkill(knowledge) })
                binding.list.adapter = adapter


            }
        })

        viewModel.navigated.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(KnowledgeFragmentDirections.actionKnowledgeFragmentToSkillFragment(it))
                viewModel.onNavigateToSkillDone()
            }
        })

        return binding.root
    }

}