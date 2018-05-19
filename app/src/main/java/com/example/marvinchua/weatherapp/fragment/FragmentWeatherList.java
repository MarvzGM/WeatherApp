package com.example.marvinchua.weatherapp.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marvinchua.weatherapp.R;
import com.example.marvinchua.weatherapp.ViewModel.VM_ActivityMain;
import com.example.marvinchua.weatherapp.AdapterWeather;
import com.example.marvinchua.weatherapp.databinding.FragmentWeatherListBinding;

public class FragmentWeatherList extends Fragment
{
    FragmentWeatherListBinding binding;
    private VM_ActivityMain viewModel;

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_list, container, false);

        return binding.getRoot();
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(VM_ActivityMain.class);

        binding.recyclerWeatherList
                .addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerWeatherList.setAdapter(new AdapterWeather(viewModel, getActivity()));
        binding.recyclerWeatherList.setLayoutManager(new LinearLayoutManager(getContext()));



        observeViewModel();

    }

    private void observeViewModel()
    {
        viewModel.getLocations().observe(this, locations -> {
            if (locations != null)
            {
                binding.recyclerWeatherList.setVisibility(View.VISIBLE);
            }
        });

        viewModel.getLoadingError().observe(this, isError -> {
            if (isError)
            {
                binding.recyclerWeatherList.setVisibility(View.GONE);
                binding.textViewPrompt.setText(R.string.error_api);
            }
            binding.textViewPrompt.setVisibility(isError ? View.VISIBLE : View.GONE);

        });

        viewModel.getLoading().observe(this, isLoading -> {
            binding.loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            if (isLoading)
            {
                binding.recyclerWeatherList.setVisibility(View.GONE);
                binding.textViewPrompt.setVisibility(View.GONE);
            }
        });
    }
}
