package com.mycompany.mvvmletsgo.data

// FakeCommentDao must be passed in - it is a dependency
// You could also instantiate the DAO right inside the class without all the fuss, right?
// No. This would break testability - you need to be able to pass a mock version of a DAO
// to the repository (e.g. one that upon calling getComments() returns a dummy list of comments for testing)
// This is the core idea behind DEPENDENCY INJECTION - making things completely modular and independent.
class CommentRepository private constructor(private val commentDao: FakeCommentDao){

    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun addComment(comment: Comment) {
        commentDao.addComment(comment)
    }

    fun getComment() = commentDao.getComments()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: CommentRepository? = null

        fun getInstance(commentDao: FakeCommentDao) =
            instance ?: synchronized(this) {
                instance ?: CommentRepository(commentDao).also { instance = it }
            }
    }
}
