package com.example.test.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "ten dem khong duoc de trong")
    private String preName;
    @NotBlank(message = "ten khong duoc de trong")
    private String name;
    private String birthday;
    @Size(min = 1, max = 10,message = "Khong dam bao")
    private String phone;
    @Email(message = "regex not acp")
    private String email;
    private String address;
    private String sex;
    private String code;
    private MultipartFile avatar;
    private String account;
    private String password;
    private MultipartFile frontIdCard;
    private MultipartFile backIdCard;



}
