package com.example.marvinchua.weatherapp;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.marvinchua.weatherapp.ViewHolder.VH_Weather;
import com.example.marvinchua.weatherapp.ViewModel.VM_ActivityMain;
import com.example.marvinchua.weatherapp.databinding.ItemLocationBinding;
import com.example.marvinchua.weatherapp.model.Locations;

import java.util.ArrayList;

public class AdapterWeather extends RecyclerView.Adapter<VH_Weather>
{
    private ArrayList<Locations> item = new ArrayList<>();
    private Context context;

    public AdapterWeather(VM_ActivityMain viewModel,
            LifecycleOwner lifecycleOwner)//, LocationsSelectedListener locationsSelectedListener)
    {
        viewModel.getLocations().observe(lifecycleOwner, locations -> {
            item.clear();
            if (locations != null)
            {
                item.addAll(locations);
            }
            notifyDataSetChanged();
        });
        setHasStableIds(true);
    }

    @Override public VH_Weather onCreateViewHolder(ViewGroup parent, int viewType)
    {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //        ItemLocationBinding itemBinding = DataBindingUtil
        //                .inflate(layoutInflater, R.layout.item_location, parent, false);
        ItemLocationBinding itemBinding =
                ItemLocationBinding.inflate(layoutInflater, parent, false);

        return new VH_Weather(itemBinding);
    }
    @Override public void onBindViewHolder(VH_Weather holder, int position)
    {
        holder.bind(context,item.get(position));
    }
    @Override public long getItemId(int position)
    {


        return item.get(position).id;
    }



    @Override public int getItemCount()
    {
        return item.size();
    }


}
