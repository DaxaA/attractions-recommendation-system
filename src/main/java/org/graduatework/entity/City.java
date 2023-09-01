package org.graduatework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private int count;

    @Column(name = "information")
    private String information;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Attraction> attractionList = new ArrayList<>();
}
