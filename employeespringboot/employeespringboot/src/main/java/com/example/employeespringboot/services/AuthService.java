package com.example.employeespringboot.services;

import com.example.employeespringboot.models.RegisterDetails;
import com.example.employeespringboot.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;
    public String addNewEmployee(RegisterDetails register){
        RegisterDetails registerDetails=new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(registerDetails.getGender());
        registerDetails.setRole(registerDetails.getRole());
        registerDetails.setPassword(registerDetails.getPassword());
        registerDetails.setDateOfBirth(register.getDateOfBirth());
        registerDetails.setEmpname(registerDetails.getEmpname());
        registerDetailsRepository.save(register);
        return "Employee added successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
        if(user!=null){
            if(Objects.equals(user.getPassword(), login.getPassword())){
                return "Login Successful";
            }else {
                return "Login not successfull";
            }
        }else{
            return "Login not successfull";
}
}


}
