package com.example.test.models;


import com.example.test.bases.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "traffic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Traffic extends BaseEntity {

    @NotNull
    @Nationalized
    @Column(name = "name_traffic",unique = true)
    private String name;

    @NotNull
    @Nationalized
    @Column(name = "type_of_traffic")
    private String type;

    @NotNull
    @Column(name = "license_plate_traffic", unique = true)
    private String licensePlate;

    @NotNull
    @Column(name = "color_traffic")
    private String color;

    @NotNull
    @Column(name = "brand_traffic")
    private String brand;

    @NotNull
    @Column(name = "code_traffic")
    private String code;

    @NotNull
    @Column(name = "avatar_traffic")
    private String avatar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_user")
    private User userTraffic;

    @OneToMany(mappedBy = "traffic",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Borrower> borrowers;

    @OneToMany(mappedBy = "trafficTime",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Time> times;
}
