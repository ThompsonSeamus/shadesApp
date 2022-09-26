package com.example.shadesapp;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shadesapp.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.shadesapp.databinding.FragmentShadeBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ShadeRecyclerViewAdapter extends RecyclerView.Adapter<ShadeRecyclerViewAdapter.ViewHolder> {

    private final List<Shade> mValues;
    private Context context;
    public ShadeRecyclerViewAdapter(List<Shade> items, Context context)
    {
        this.context = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentShadeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.shade = mValues.get(position);
        holder.shadeNameView.setText(holder.shade.getName());
        holder.shadeNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView shadeNameView;
        public Shade shade;

        public ViewHolder(FragmentShadeBinding binding) {
            super(binding.getRoot());
            shadeNameView = binding.shadeNameTextView;
        }
    }
}