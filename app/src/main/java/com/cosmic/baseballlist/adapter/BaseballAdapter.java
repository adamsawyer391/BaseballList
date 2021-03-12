package com.cosmic.baseballlist.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.cosmic.baseballlist.R;
import com.cosmic.baseballlist.model.BaseballTeam;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class BaseballAdapter extends RecyclerView.Adapter<BaseballAdapter.BaseballViewHolder> {

    private final Context context;
    private final List<BaseballTeam> baseballTeams;
    private boolean isDualPane = false;

    public BaseballAdapter(Context context, List<BaseballTeam> baseballTeams, boolean isDualPane) {
        this.context = context;
        this.baseballTeams = baseballTeams;
        this.isDualPane = isDualPane;
    }

    @NonNull
    @Override
    public BaseballViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (isDualPane){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_list_item_small, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_list_item, parent, false);
        }
        return new BaseballViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseballViewHolder holder, int position) {
        Glide.with(context).load(baseballTeams.get(position).getStadium_url()).into(holder.circleImageView);
        holder.textView.setText(baseballTeams.get(position).getTeam_name());
    }

    @Override
    public int getItemCount() {
        return baseballTeams.size();
    }

    static class BaseballViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        TextView textView;

        public BaseballViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.teamPhoto);
            textView = itemView.findViewById(R.id.teamName);
        }
    }
}
