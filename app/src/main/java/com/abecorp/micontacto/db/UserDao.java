/*
Tanggal Pengerjaan : 05 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */

package com.abecorp.micontacto.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.abecorp.micontacto.model.User;


@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addUser(User... users);

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    LiveData<User> login(String username, String password);
}
