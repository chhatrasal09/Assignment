package chhatrasal.app.com.redcarpetassignment.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import chhatrasal.app.com.redcarpetassignment.ImageViewActivity;
import chhatrasal.app.com.redcarpetassignment.R;
import chhatrasal.app.com.redcarpetassignment.javaClass.CountryPopulation;

/**
 * Created by chhatrasal on 31/7/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private List<CountryPopulation> list;
    private Context context;

    public RecyclerViewAdapter(List<CountryPopulation> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.getRankView().setText(String.valueOf(list.get(position).getRank()));
        holder.getPopulationView().setText(list.get(position).getPopulation());
        holder.getCountryView().setText(list.get(position).getCountry());
        Picasso.with(context)
                .load(list.get(position).getImageUrl())
                .resize(250,200).
                into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView rankView;
        private TextView countryView;
        private TextView populationView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            rankView =  itemView.findViewById(R.id.rank_view);
            countryView = itemView.findViewById(R.id.country_view);
            populationView =  itemView.findViewById(R.id.population_view);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getRankView() {
            return rankView;
        }

        public void setRankView(TextView rankView) {
            this.rankView = rankView;
        }

        public TextView getCountryView() {
            return countryView;
        }

        public void setCountryView(TextView countryView) {
            this.countryView = countryView;
        }

        public TextView getPopulationView() {
            return populationView;
        }

        public void setPopulationView(TextView populationView) {
            this.populationView = populationView;
        }
    }
}
