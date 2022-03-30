package com.geektech.postapp.utils.interfaces;

import com.geektech.postapp.data.models.PostModel;

public interface OnClick {
    void onClick(PostModel postModel);
    void onLongClick(PostModel postModel);
}
