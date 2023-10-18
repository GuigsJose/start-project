package com.br.projeto.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "User_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "profession")
    private String profession;

}
