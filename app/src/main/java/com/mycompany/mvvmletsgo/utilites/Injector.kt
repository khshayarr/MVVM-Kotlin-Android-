package com.mycompany.mvvmletsgo.utilites

import com.mycompany.mvvmletsgo.data.CommentRepository
import com.mycompany.mvvmletsgo.data.FakeDatabase
import com.mycompany.mvvmletsgo.ui.comment.CommentViewModelFactory

// Finally a singleton which doesn't need anything passed to the constructor
object Injector {

    // This will be called from QuotesActivity
    fun provideCommentViewModelFactory(): CommentViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val commentRepository = CommentRepository.getInstance(FakeDatabase.getInstance().commentDao)
        return CommentViewModelFactory(commentRepository)
    }
}