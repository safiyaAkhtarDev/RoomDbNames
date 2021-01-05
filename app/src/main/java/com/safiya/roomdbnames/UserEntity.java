package com.safiya.roomdbnames;

@Entity
data class UserEntity(
        @PrimaryKey var title: String,
        @ColumnInfo(name = "content") var content: String
)
