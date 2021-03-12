package com.cosmic.baseballlist.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.cosmic.baseballlist.R;
import com.cosmic.baseballlist.model.BaseballTeam;

public class ItemDetailFragment extends Fragment {

    private BaseballTeam baseballTeam;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseballTeam = (BaseballTeam) getArguments().getSerializable("baseball");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);

        Context context = getActivity();

        ImageView imageView = view.findViewById(R.id.stadium_photo);
        TextView tvTeamName = view.findViewById(R.id.team_name);
        TextView tvRecord = view.findViewById(R.id.tvRecord);
        TextView tvHometown = view.findViewById(R.id.tvHometown);
        TextView tvStadiumName = view.findViewById(R.id.tvStadiumName);
        TextView tvDescription = view.findViewById(R.id.tvDescription);

        Glide.with(context).load(baseballTeam.getStadium_url()).into(imageView);
        tvTeamName.setText(baseballTeam.getTeam_name());
        tvRecord.setText(baseballTeam.getRecord());
        tvHometown.setText(baseballTeam.getHometown());
        tvStadiumName.setText(baseballTeam.getStadium_name());
        tvDescription.setText(baseballTeam.getDescription());

        return view;
    }

    public static ItemDetailFragment newInstance(BaseballTeam baseballTeam){
        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("baseball", baseballTeam);
        itemDetailFragment.setArguments(bundle);
        return itemDetailFragment;
    }
}
