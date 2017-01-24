package com.marcelib.community.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "user_vote", uniqueConstraints = @UniqueConstraint(
        columnNames = {"author_id", "user_post_id"}))
public class UserVote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "value")
    private boolean value;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private long authorId;

    @ManyToMany(targetEntity = UserPost.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_post_id")
    private long userPostId;
}
