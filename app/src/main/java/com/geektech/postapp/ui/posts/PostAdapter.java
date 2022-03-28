package com.geektech.postapp.ui.posts;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.postapp.OnClick;
import com.geektech.postapp.data.models.PostModel;
import com.geektech.postapp.databinding.ItemPostBinding;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private static OnClick onClick;
    private List<PostModel> postModelList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setPostModelList(List<PostModel> postModelList) {
        this.postModelList = postModelList;
        notifyDataSetChanged();
    }

    public PostAdapter(OnClick onClick) {
        this.onClick = onClick;
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
            itemView.setOnClickListener(view -> {
                onClick.onClick(postModel);
            });
            itemView.setOnLongClickListener(view -> {
                onClick.onLongClick(postModel);
                return true;
            });
        }
    }
}
