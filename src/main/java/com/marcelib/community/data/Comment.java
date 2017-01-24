package com.marcelib.community.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "date_added")
    private Date dateAdded;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private long authorId;

    @ManyToMany(targetEntity = UserPost.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_post_id")
    private long userPostId;
}
