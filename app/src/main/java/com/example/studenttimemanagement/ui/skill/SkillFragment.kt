package com.example.studenttimemanagement.ui.skill

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.studenttimemanagement.R
import com.example.studenttimemanagement.databinding.SkillFragmentBinding

class SkillFragment : Fragment() {

    private lateinit var viewModel: SkillViewModel
    private lateinit var binding: SkillFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.skill_fragment, container, false)
        val knowledge = SkillFragmentArgs.fromBundle(requireArguments()).knowledgeArg
        binding.knowledgeName.text = knowledge.name
        return binding.root
    }

}