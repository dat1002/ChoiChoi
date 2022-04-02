package com.example.test.utils;

import com.example.test.dtos.*;
import com.example.test.models.*;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

public class ConvertDTOToDAO {

    public static User fromUserDTOToUser(User user, UserDTO userDTO){
        if (userDTO.getPreName() != null){
            user.setPreName(userDTO.getPreName());
        }
        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getBirthday() != null) {
            user.setBirthday(userDTO.getBirthday());
        }
        if (userDTO.getPhone() != null) {
            user.setPhone(userDTO.getPhone());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getAddress() != null) {
            user.setAddress(userDTO.getAddress());
        }
        if (userDTO.getSex() != null) {
            user.setSex(userDTO.getSex());
        }
        user.setAccount(userDTO.getAccount());
        if (userDTO.getName() != null) {
            user.setPassword(userDTO.getPassword());
        }
        return user;
    }
    public static Traffic fromTrafficDTOToTraffic(TrafficDTO trafficDTO){
        Traffic traffic = new Traffic();
        if(trafficDTO.getName() != null){
            traffic.setName(trafficDTO.getName());
        }
        if(trafficDTO.getType() != null){
            traffic.setType(trafficDTO.getType());
        }
        if(trafficDTO.getLicensePlate() != null){
            traffic.setLicensePlate(trafficDTO.getLicensePlate());
        }
        if(trafficDTO.getColor() != null){
            traffic.setColor(trafficDTO.getColor());
        }
        if(trafficDTO.getBrand() != null){
            traffic.setBrand(trafficDTO.getBrand());
        }
        if(trafficDTO.getCode() != null){
            traffic.setCode(trafficDTO.getCode());
        }
        if(trafficDTO.getAvatar() != null){
            traffic.setAvatar(trafficDTO.getAvatar());
        }
        return traffic;
    }
    public static Borrower fromBorrowerDTOToBorrower(BorrowerDTO borrowerDTO){
        Borrower borrower = new Borrower();
        if(borrowerDTO.getCode() != null){
            borrower.setCode(borrowerDTO.getCode());
        }
        return borrower;
    }
    public static Role fromRoleDTOToRole(RoleDTO roleDTO){
        Role role = new Role();
        if(roleDTO.getName() != null){
            role.setName(roleDTO.getName());
        }
        return role;
    }

}
