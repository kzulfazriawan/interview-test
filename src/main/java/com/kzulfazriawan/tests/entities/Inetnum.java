package com.kzulfazriawan.tests.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inetnum")
public class Inetnum {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, name = "inet_num")
    private String inetNum;

    @Column(nullable = false, name = "net_name")
    private String netName;

    @Column(nullable = false)
    private String description;
}
