package com.example.test.controllers;

import com.example.test.bases.BaseController;
import com.example.test.dtos.UserDTO;
import com.example.test.models.User;
import com.example.test.payload.AuthenticationRequest;
import com.example.test.services.IUserService;
import com.example.test.services.imp.SendMailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User> {
    @Autowired
    private IUserService userService;

    @Autowired
    private SendMailServiceImp sendMailServiceImp;
    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDTO userDTO) {
        return this.resSuccess(userService.createUser(userDTO));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> findAllUser() {
        return this.resSetSuccess(userService.getAllUser());
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteUserById(@PathVariable(name = "idUser") Integer id) {
        return this.resSuccess(userService.deleteUserById(id));
    }

    @GetMapping("/get-all-by-name")
    public ResponseEntity<?> getAllUserByName(@RequestParam("name") String name){
        return this.resSetSuccess(userService.getAllUserByName(name));
    }
    
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return this.resSuccess(userService.login(authenticationRequest));
    }

    @PutMapping("/edit/{idUser}")
    public ResponseEntity<?> editUserById(@PathVariable("idUser") Integer id,@ModelAttribute UserDTO userDTO) {
        return this.resSuccess(userService.editUserById(userDTO,id));
    }
    @PatchMapping("/editAvatar/{idUser}")
    public ResponseEntity<?> editAvtById(@PathVariable("idUser")Integer id, @RequestParam("avatar") MultipartFile file) {
        return this.resSuccess(userService.editAvatarUserById(file,id));
    }
    @PatchMapping("/editBackIdCard/{idUser}")
    public ResponseEntity<?> editBackIdCard(@PathVariable("idUser")Integer id, @RequestParam("back") MultipartFile file) {
        return this.resSuccess(userService.editBackIdCardById(file,id));
    }
    @PatchMapping("/editFrontIdCard/{idUser}")
    public ResponseEntity<?> editFrontIdCard(@PathVariable("idUser")Integer id, @RequestParam("front") MultipartFile file) {
        return this.resSuccess(userService.editBackIdCardById(file,id));
    }
}
