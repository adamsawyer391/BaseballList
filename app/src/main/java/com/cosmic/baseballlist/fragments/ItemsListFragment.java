package com.cosmic.baseballlist.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cosmic.baseballlist.R;
import com.cosmic.baseballlist.adapter.BaseballAdapter;
import com.cosmic.baseballlist.helper.RecycleClick;
import com.cosmic.baseballlist.model.BaseballTeam;
import java.util.ArrayList;

public class ItemsListFragment extends Fragment{

    private OnListItemSelectedListener listener;
    private final boolean isDualPane;

    public ItemsListFragment(boolean isDualPane) {
        this.isDualPane = isDualPane;
    }

    public interface OnListItemSelectedListener{
        void onItemSelected(BaseballTeam baseballTeam);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnListItemSelectedListener){
            listener = (OnListItemSelectedListener) activity;
        }else{
            throw new ClassCastException(activity.toString());
        }
    }

    private final ArrayList<BaseballTeam> baseballTeams = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        compileTeams();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BaseballAdapter baseballAdapter = new BaseballAdapter(getActivity(), baseballTeams, isDualPane);
        recyclerView.setAdapter(baseballAdapter);
        recyclerView.addOnItemTouchListener(new RecycleClick(getActivity(), (view1, position) -> {
            BaseballTeam baseballTeam = baseballTeams.get(position);
            listener.onItemSelected(baseballTeam);
        }));
        return view;
    }

    private void compileTeams(){
        String[] teams = getActivity().getResources().getStringArray(R.array.baseball_teams);
        String[] cities = getActivity().getResources().getStringArray(R.array.cities);
        String[] stadiums = getActivity().getResources().getStringArray(R.array.stadiums);
        String[] records = getActivity().getResources().getStringArray(R.array.records);
        String[] urls = getActivity().getResources().getStringArray(R.array.urls);
        String[] description = getActivity().getResources().getStringArray(R.array.description);
        for (int i = 0; i < 30; i++){
            BaseballTeam baseballTeam = new BaseballTeam(teams[i], cities[i], stadiums[i], records[i], urls[i], description[i]);
            baseballTeams.add(baseballTeam);
        }

    }
}
