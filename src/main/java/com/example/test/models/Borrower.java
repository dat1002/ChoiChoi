package com.example.test.models;

import com.example.test.bases.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "borrower")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrower extends BaseEntity {

    @Column(name = "code_user",unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_traffic")
    private Traffic traffic;
}
