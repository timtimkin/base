package com.example.notes.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bam.roomexample.room.Note
import com.example.notes.R
import com.example.notes.databinding.NoteItemBinding

class NoteListAdapter: RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    var notes: List<Note> = mutableListOf()

    fun updateList(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var binding: NoteItemBinding= NoteItemBinding.bind(view)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.note = notes[position]
    }

    override fun getItemCount(): Int {
      return notes.size
    }

}

