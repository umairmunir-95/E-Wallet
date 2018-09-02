package com.example.umairmunirahmad.e_wallet.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.umairmunirahmad.e_wallet.R;
import com.example.umairmunirahmad.e_wallet.adapters.GridViewCategoriesAdapter;
import com.example.umairmunirahmad.e_wallet.models.categories.Category;
import com.example.umairmunirahmad.e_wallet.utils.DialogueManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CategoryIncomingFragment extends Fragment {

    @BindView(R.id.recycler_view) RecyclerView categoriesRecyclerView;
    @BindView(R.id.fab) FloatingActionButton addNewfab;
    private View view;
    private Unbinder unbinder;
    private List<Category> categoriesList = new ArrayList<>();
    private GridViewCategoriesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try
        {
            view = inflater.inflate(R.layout.category_incoming_fragment, container, false);
            unbinder=ButterKnife.bind(this,view);
            initializeViews();
            prepareListData();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initializeViews()
    {
        addNewfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogueManager.showCategoryDialog(getActivity(),"INCOMING");
            }
        });
    }

    private void prepareListData() {
        Category category = new Category();
        category.setCategoryName("Grocerry");
        categoriesList.add(category);
        Category category2 = new Category();
        category2.setCategoryName("Eating-Out");
        categoriesList.add(category2);

        mAdapter = new GridViewCategoriesAdapter(categoriesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        categoriesRecyclerView.setLayoutManager(mLayoutManager);
        categoriesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoriesRecyclerView.setAdapter(mAdapter);
    }

}
