package com.sh.study.udacitynano.bakingapp.recipes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh.study.udacitynano.bakingapp.R;
import com.sh.study.udacitynano.bakingapp.model.Step;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepAdapterViewHolder> {
    private List<Step> steps;

    public void setSteps(List<Step> steps) {
        this.steps = steps;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StepAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_inredient, parent, false);
        return new StepAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepAdapterViewHolder holder, int position) {
        holder.stepName.setText("Step " + String.valueOf(steps.get(position).getId()));
        holder.stepDescriptionShort.setText(String.valueOf(steps.get(position).getShortDescription()));
        holder.stepDescriptionLong.setText(String.valueOf(steps.get(position).getDescription()));

/*
        Picasso.with(holder.mPoster.getContext())
                .load(String.valueOf(NetworkUtils.buildUrlForPoster(movies.get(position).posterPath())))
                .into(holder.mPoster);

        holder.stepThumb.setText(String.valueOf(steps.get(position).getThumbnailURL()));
        holder.stepThumb.setText(String.valueOf(steps.get(position).getVideoURL()));
*/
    }

    @Override
    public int getItemCount() {
        if (steps == null) return 0;
        else return steps.size();
    }

    public class StepAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.step_name)
        TextView stepName;

        @BindView(R.id.recipe_step_description_short)
        TextView stepDescriptionShort;

        @BindView(R.id.recipe_step_description_long)
        TextView stepDescriptionLong;

        @BindView(R.id.recipe_step_thumb_url)
        ImageView stepThumb;

        @BindView(R.id.recipe_step_video_url)
        ImageView stepVideo;

        public StepAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
