package com.guercifzone.wl_ninja.Adapters;

import static android.app.Activity.RESULT_OK;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guercifzone.wl_ninja.R;


public class RecentTabAdapter extends RecyclerView.Adapter<RecentTabAdapter.CustomVH> {
    private Context context;
    private int current;

    public RecentTabAdapter(Context context, int current) {
        this.context = context;
        this.current = current;
    }

    @NonNull
    @Override
    public CustomVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_tab, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CustomVH holder, int position) {
        holder.setTab(webViews.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class CustomVH extends RecyclerView.ViewHolder {
        private final TextView url, title;
        private final ImageView favicon;

        public CustomVH(@NonNull View parentView) {
            super(parentView);
            url = parentView.findViewById(R.id.url);
            title = parentView.findViewById(R.id.title);
            favicon = parentView.findViewById(R.id.favicon);
            ImageView close = parentView.findViewById(R.id.close);
            LinearLayout root = parentView.findViewById(R.id.root);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == current)
                        current = 0;
                    webViews.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
    }
}