package com.cosmic.baseballlist;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.cosmic.baseballlist.fragments.ItemDetailFragment;
import com.cosmic.baseballlist.fragments.ItemsListFragment;
import com.cosmic.baseballlist.model.BaseballTeam;

public class ItemDetailActivity extends AppCompatActivity {

    ItemDetailFragment itemDetailFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        BaseballTeam baseballTeam = (BaseballTeam) getIntent().getSerializableExtra("baseball");
        if (savedInstanceState == null){
            itemDetailFragment = ItemDetailFragment.newInstance(baseballTeam);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, itemDetailFragment);
            fragmentTransaction.commit();
        }
    }
}
