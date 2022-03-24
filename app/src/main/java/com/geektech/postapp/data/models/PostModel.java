package com.geektech.postapp.data.models;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    int id;
    String title;
    String content;
    @SerializedName("user")
    int userId;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getUserId() {
        return userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public PostModel(String title, String content, int userId, int groupId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.groupId = groupId;
    }

    @SerializedName("group")
    int groupId;
}
