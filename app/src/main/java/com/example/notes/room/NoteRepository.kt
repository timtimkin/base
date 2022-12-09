package com.example.notes.room

import androidx.lifecycle.LiveData
import com.bam.roomexample.room.Note

class NoteRepository (var dataBase: DbConnection) {

    var notes: LiveData<List<Note>> = dataBase.noteDao().getAll()

    fun getAll(): LiveData<List<Note>>{
        return notes
    }

    suspend fun insert(note: Note){
        dataBase.noteDao().insert(note)
    }

    suspend fun delete(note: Note){
        dataBase.noteDao().delete(note)
    }
}