/*
Tanggal Pengerjaan : 03 - 08 - 2019
NIM     : 10116342
Nama    : Ma'sum Abdul Matin
Kelas   : IF 8
 */
package com.abecorp.micontacto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abecorp.micontacto.AddAndEditFriendsActivity;
import com.abecorp.micontacto.FriendsAdapter;
import com.abecorp.micontacto.R;
import com.abecorp.micontacto.model.Friends;
import com.abecorp.micontacto.presenter.FriendsListPresenter;
import com.abecorp.micontacto.view.FriendsListView;

import java.util.ArrayList;
import java.util.List;



public class FriendsListFragment extends Fragment implements FriendsListView, View.OnClickListener {

    FriendsAdapter adapter;
    ArrayList<Friends> friends;
    static FriendsListPresenter presenter;
    RecyclerView rvFriends;
    FloatingActionButton fab;


    public FriendsListFragment() {
        // Required empty public constructor
    }


    @Override
    public void showFriendsList(List<Friends> friends) {
        this.friends.clear();
        this.friends.addAll(friends);
        adapter.notifyDataSetChanged();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        rvFriends = view.findViewById(R.id.rvFriends);
        fab = view.findViewById(R.id.fabAddFriends);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        friends = new ArrayList<>();
        adapter = new FriendsAdapter(friends, getActivity());
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);

        presenter = new FriendsListPresenter(getContext(),this);
        presenter.setFriendsList(this);

        fab.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabAddFriends) {
                Intent i = new Intent(getContext(), AddAndEditFriendsActivity.class);
                i.putExtra("type", 0);
                startActivity(i);
        }
    }

}
