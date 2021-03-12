package com.cosmic.baseballlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.cosmic.baseballlist.fragments.ItemDetailFragment;
import com.cosmic.baseballlist.fragments.ItemsListFragment;
import com.cosmic.baseballlist.model.BaseballTeam;

public class ListActivity extends AppCompatActivity implements ItemsListFragment.OnListItemSelectedListener {

    private boolean isDualPane = false;
    private boolean twoPanel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        determinePaneLayout();
        twoPanel = isDualPane;

        ItemsListFragment itemsListFragment = new ItemsListFragment(twoPanel);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentList, itemsListFragment);
        fragmentTransaction.commit();
    }

    private void determinePaneLayout(){
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frameContainer);
        if (frameLayout != null){
            isDualPane = true;
        }
    }

    @Override
    public void onItemSelected(BaseballTeam baseballTeam) {
        if (isDualPane){
            ItemDetailFragment itemDetailFragment = ItemDetailFragment.newInstance(baseballTeam);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, itemDetailFragment);
            fragmentTransaction.commit();
        }else{
            Intent intent = new Intent(this, ItemDetailActivity.class);
            intent.putExtra("baseball", baseballTeam);
            startActivity(intent);
        }
    }
}