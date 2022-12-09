package com.example.notes.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.notes.R
import com.example.notes.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {

    private lateinit var binding: FragmentNoteListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "db").build()
        var repository = NoteRepository (db)
        var adapter = NoteListAdapter()

        repository.notes.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }

        binding.rvNotes.adapter = adapter

        binding.btnNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_noteListFragment_to_noteCreateFragment)

        }
  }

}