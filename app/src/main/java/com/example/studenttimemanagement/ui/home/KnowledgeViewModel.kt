package com.example.studenttimemanagement.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studenttimemanagement.model.Knowledge

class KnowledgeViewModel : ViewModel() {

    private var _knowledges = MutableLiveData<List<Knowledge>>()
    val knowledges: LiveData<List<Knowledge>>
    get() = _knowledges

    private var _navigated = MutableLiveData<Knowledge?>()
    val navigated: LiveData<Knowledge?>
    get() = _navigated

    init {
        _knowledges.value = listOf(
            Knowledge(1, "informatics", "description de l'ínfo "),
            Knowledge(2, "informatics2", "description de l'ínfo2 "),
            Knowledge(3, "informatics3", "description de l'ínfo3 "),
            Knowledge(4, "informatics4", "description de l'ínfo4 "),

        )
    }

    fun onNavigateToSkill(knowledge: Knowledge) {
        _navigated.value = knowledge
    }

    fun onNavigateToSkillDone() {
        _navigated.value = null
    }
}