package com.trung.reddit.mapper;

import com.trung.reddit.dto.PostRequest;
import com.trung.reddit.dto.PostResponse;
import com.trung.reddit.model.Post;
import com.trung.reddit.model.Subreddit;
import com.trung.reddit.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", expression = "java(post.getSubreddit().getName())")
    @Mapping(target = "username", expression = "java(post.getUser().getUsername())")
    PostResponse mapToDto(Post post);

}
