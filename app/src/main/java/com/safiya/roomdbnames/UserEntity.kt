package com.safiya.roomdbnames

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "user")
data class UserEntity(

    @field:Json(name = "name")
    @ColumnInfo(name = "name") var name: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}