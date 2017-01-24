package com.marcelib.community.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "user_post")
public class UserPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "short_title")
    private String shortTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "date_added")
    private Date dateAdded;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private long authorId;

}
