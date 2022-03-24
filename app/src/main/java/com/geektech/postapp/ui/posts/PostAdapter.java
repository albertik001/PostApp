package com.geektech.postapp.ui.posts;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.postapp.data.models.PostModel;
import com.geektech.postapp.databinding.ItemPostBinding;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<PostModel> postModelList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setPostModelList(List<PostModel> postModelList) {
        this.postModelList = postModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bind(postModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    protected static class PostViewHolder extends RecyclerView.ViewHolder {
        private ItemPostBinding binding;

        public PostViewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(PostModel postModel) {
            binding.userId.setInputType(postModel.getUserId());
            binding.title.setText(postModel.getTitle());
            binding.content.setText(postModel.getContent());
        }
    }
}
