package com.bam.roomexample.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(var title: String, var description: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}