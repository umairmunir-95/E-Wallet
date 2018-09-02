package com.example.umairmunirahmad.e_wallet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.umairmunirahmad.e_wallet.R;
import com.example.umairmunirahmad.e_wallet.models.categories.Category;

import java.util.List;

public class GridViewCategoriesAdapter extends RecyclerView.Adapter<GridViewCategoriesAdapter.MyViewHolder> {

    private List<Category> categoriesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryNameTextView;
        public ImageView navigateNextImageView;

        public MyViewHolder(View view) {
            super(view);
            categoryNameTextView = view.findViewById(R.id.tv_category_name);
            navigateNextImageView =  view.findViewById(R.id.iv_next);
        }
    }


    public GridViewCategoriesAdapter(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gv_category_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category category = categoriesList.get(position);
        holder.categoryNameTextView.setText(category.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
}
