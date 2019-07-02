package com.mycompany.mvvmletsgo.ui.comment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mycompany.mvvmletsgo.data.CommentRepository

class CommentViewModelFactory (private val commentRepository: CommentRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CommentViewModel(commentRepository) as T
    }
}