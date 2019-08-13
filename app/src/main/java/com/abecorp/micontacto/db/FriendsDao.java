/*
Tanggal Pengerjaan : 05 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */
package com.abecorp.micontacto.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.abecorp.micontacto.model.Friends;

import java.util.List;

@Dao
public interface FriendsDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addFriend(Friends... friends);

    @Delete
    void deleteFriend(Friends... friends);

    @Update
    void updateFriend(Friends... friends);

    @Query("SELECT * FROM friends ORDER BY nim")
    LiveData<List<Friends>> getAll();
}