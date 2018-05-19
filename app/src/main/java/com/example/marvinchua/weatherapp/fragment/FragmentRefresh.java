package com.example.marvinchua.weatherapp.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marvinchua.weatherapp.R;
import com.example.marvinchua.weatherapp.ViewModel.VM_ActivityMain;
import com.example.marvinchua.weatherapp.databinding.FragmentRefreshBinding;

public class FragmentRefresh extends Fragment
{
    FragmentRefreshBinding binding;
    private VM_ActivityMain viewModel;
    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_refresh, container, false);
        viewModel = ViewModelProviders.of(getActivity()).get(VM_ActivityMain.class);
        binding.buttonRefreshMain.setOnClickListener(view1 -> {
            viewModel.refresh();
        });
        return binding.getRoot();
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


    }
}
