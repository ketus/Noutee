package com.example.noutee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noutee.DB.NoteDatabase
import com.example.noutee.repository.NoteRepository
import com.example.noutee.ui.theme.NoteApp
import com.example.noutee.repository.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = NoteDatabase.getDatabase(this)
        val repository = NoteRepository(database.noteDao())
        val factory = NoteViewModelFactory(repository)

        setContent {
            val viewModel: NoteViewModel = viewModel(factory = factory)
            NoteApp(viewModel = viewModel)
        }
    }
}
