package com.geektech.postapp.ui.form;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geektech.postapp.App;
import com.geektech.postapp.data.models.PostModel;
import com.geektech.postapp.databinding.FragmentFormBinding;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormFragment extends Fragment {
    private FragmentFormBinding binding;
    public static final int GROUP_ID = 40;
    private static final int USER_ID = 1;
    private PostModel postModel;

    public FormFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(inflater, container, false);
        return (binding.getRoot());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String titles = FormFragmentArgs.fromBundle(getArguments()).getTitle();
        String contents = FormFragmentArgs.fromBundle(getArguments()).getContent();

        if (postModel != null) {
            binding.etContent.setText(contents);
            binding.etTitle.setText(titles);
        }
        binding.btnSend.setOnClickListener(view1 -> {
            String title = binding.etTitle.getText().toString();
            String content = binding.etContent.getText().toString();
            if (getArguments() != null) {
                postModel.setContent(content);
                postModel.setTitle(title);
                App.api.updatePost(postModel.getId(), postModel).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            requireActivity().onBackPressed();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            } else {
                PostModel postModel = new PostModel(title, content, USER_ID, GROUP_ID);
                App.api.createPost(postModel).enqueue(new Callback<PostModel>() {
                    @Override
                    public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                        if (response.isSuccessful()) {
                            requireActivity().onBackPressed();
                        }
                    }

                    @Override
                    public void onFailure(Call<PostModel> call, Throwable t) {

                    }
                });
            }
        });
    }
}