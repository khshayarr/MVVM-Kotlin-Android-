package com.mycompany.mvvmletsgo.ui.comment

import androidx.lifecycle.ViewModel
import com.mycompany.mvvmletsgo.data.Comment
import com.mycompany.mvvmletsgo.data.CommentRepository
// CommentRepository dependency will again be passed in the
// constructor using dependency injection
class CommentViewModel(private val commentRepository: CommentRepository) : ViewModel() {
    fun getComment() = commentRepository.getComment()

    fun addComment(comment: Comment) = commentRepository.addComment(comment)

}