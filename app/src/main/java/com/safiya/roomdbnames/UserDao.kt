package com.safiya.roomdbnames

import androidx.room.*


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user WHERE name LIKE :name")
    fun findByname(name: String): UserEntity
//
//    @Query("delete FROM user")
//    fun deleteAll(): UserEntity

    @Insert
    fun insertAll(vararg todo: UserEntity)

    @Delete
    fun delete(todo: UserEntity)

    @Update
    fun updateUser(vararg todos: UserEntity)
}