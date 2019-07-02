package com.mycompany.mvvmletsgo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mycompany.mvvmletsgo.data.Comment

class FakeCommentDao {
    // A fake database table
    private val commentList = mutableListOf<Comment>()
    // MutableLiveData is from the Architecture Components Library
    // LiveData can be observed for changes
    private val comments = MutableLiveData<List<Comment>>()

    init {
        // Immediately connect the now empty commentList
        // to the MutableLiveData which can be observed
        comments.value = commentList
    }

    fun addComment(comment: Comment) {
        commentList.add(comment)
        // After adding a comment to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        comments.value = commentList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getComments() = comments as LiveData<List<Comment>>
}
