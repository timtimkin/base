package com.example.notes.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bam.roomexample.room.Note

@Database(entities = [Note::class], version = 1, exportSchema = true)
abstract class DbConnection : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}