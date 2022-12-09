package com.example.notes.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.bam.roomexample.room.Note
import com.example.notes.R
import com.example.notes.databinding.FragmentNoteCreateBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteCreateFragment : Fragment() {

    private lateinit var binding: FragmentNoteCreateBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteCreateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "db").build()
        val repository = NoteRepository(db)

        binding.btnAddNote.setOnClickListener {
            val title = binding.editTextTextPersonName.text.toString()
            val description = binding.etAddDesc.text.toString()

            GlobalScope.launch {
                repository.insert(Note(title, description))
            }

            Navigation.findNavController(it)
                .navigate(R.id.action_noteCreateFragment_to_noteListFragment)

        }

    }
}



