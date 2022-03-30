package com.geektech.postapp.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PostModel implements Serializable {
    Integer id;
    String title;
    String content;
    @SerializedName("user")
    int userId;
    @SerializedName("group")
    int groupId;

    public Integer getId()   {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostModel(String title, String content, int userId, int groupId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.groupId = groupId;
    }

}
