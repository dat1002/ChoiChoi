package com.example.test.models;

import com.example.test.bases.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    @NotNull
    @Nationalized
    @Column(name = "pre_name")
    private String preName;

    @NotNull
    @Nationalized
    @Column(name = "name_user")
    private String name;

    @NotNull
    @Column(name = "birthday_user")
    private String birthday;

    @NotNull
    @Column(name = "phone_user")
    private String phone;

    @NotNull
    @Column(name = "email_user",unique = true)
    @Email(message = "regex not acp")
    private String email;

    @NotNull
    @Nationalized
    @Length(max = 200000)
    @Column(name = "address_user")
    private String address;

    @NotNull
    @Nationalized
    @Column(name = "sex_user")
    private String sex;

    @NotNull
    @Column(name = "code_user",unique = true)
    private String code;

    @NotNull
    @Column(name = "avatar_user")
    private String avatar;

    @NotNull
    @Column(name = "account_user", unique = true)
    private String account;

    @NotNull
    @Column(name = "password_user")
    private String password;

    @NotNull
    @Column(name = "front_id_card_user")
    private String frontIdCard;

    @NotNull
    @Column(name = "back_id_card_user")
    private String backIdCard;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToMany(mappedBy = "userTraffic", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Traffic> traffic;

    @OneToMany(mappedBy = "userTime", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Time> times;

}
