package com.rest.api.utils.request;

import com.rest.api.model.Post;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CommentDto {

    private String name;

    private String email;

    private String body;

    private Long postId;
}
