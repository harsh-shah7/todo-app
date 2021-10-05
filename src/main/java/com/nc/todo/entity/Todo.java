package com.nc.todo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "timestamp")
    private Date timestamp;

    @OneToOne
    private Category category;

    @Column(name="status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
