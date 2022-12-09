package com.example.notes.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.bam.roomexample.room.Note


@Dao
interface NoteDao {

    @Query("select * from Note")
    fun getAll(): LiveData<List<Note>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}