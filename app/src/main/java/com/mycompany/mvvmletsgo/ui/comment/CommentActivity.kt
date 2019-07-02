package com.mycompany.mvvmletsgo.ui.comment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mycompany.mvvmletsgo.R
import com.mycompany.mvvmletsgo.data.Comment
import com.mycompany.mvvmletsgo.utilites.Injector
import kotlinx.android.synthetic.main.activity_main.*

class CommentActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi() {
        // Get the CommentsViewModelFactory with all of it's dependencies constructed
        val factory = Injector.provideCommentViewModelFactory()
        // Use ViewModelProviders class to create / get already created CommentsViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory)
            .get(CommentViewModel::class.java)

        // Observing LiveData from the CommentsViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getComment().observe(this, Observer { comment ->
            val stringBuilder = StringBuilder()
            comment.forEach { comment ->
                stringBuilder.append("$comment\n\n")
            }
            textView_comments.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Comment and add it to DB through the ViewModel
        button_add_comment.setOnClickListener {
            val comment = Comment(editText_comment.text.toString(), editText_author.text.toString())
            viewModel.addComment(comment)
            editText_comment.setText("")
            editText_author.setText("")
        }
    }

}