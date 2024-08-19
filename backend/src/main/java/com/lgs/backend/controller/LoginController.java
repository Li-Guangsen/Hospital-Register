package com.lgs.backend.controller;

import com.lgs.backend.model.Patient;
import com.lgs.backend.model.PatientEditBean;
import com.lgs.backend.service.PatientService;
import com.lgs.backend.service.impl.PatientServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/client")
public class LoginController {
    private PatientService patientService;
    private static PasswordEncryptor encryptor = new StrongPasswordEncryptor();
    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/login")
    public String toLogin() {
        return "client/login";
    }
    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(Patient account, HttpSession session) {
        if(!StringUtils.hasText(account.getPhone())){
            return Map.of("success", false, "error", "手机号不可为空");
        }
        Patient patient = patientService.getPatientByPhone(account.getPhone());
        if (patient == null) {
            return Map.of("success", false, "error", "用户不存在");
        }
        System.out.println(account.getPassword());
        System.out.println(patient.getPassword());
        if(encryptor.checkPassword(account.getPassword(), patient.getPassword())){
            session.setAttribute("patient", patient);
            return Map.of("success", true,"data",patient);
        }
        else {
            return Map.of("success", false, "error", "密码错误");
        }
    }
    @PostMapping("/logout")
    @ResponseBody
    public Map<String,Object> logout(HttpSession session) {
        session.removeAttribute("patient");
        return Map.of("success", true);
    }
    @PostMapping("/editPwd")
    @ResponseBody
    public Map<String,Object> editPwd(@RequestBody PatientEditBean pe, HttpSession session) {
        System.out.println(pe.getId());
        System.out.println(pe.getOldPwd());
        System.out.println(pe.getNewPwd());
        Patient patient = patientService.getPasswordById(pe.getId());
        if(!encryptor.checkPassword(pe.getOldPwd(), patient.getPassword())){
            return Map.of("success", false, "error", "原密码错误");
        }else
        {
            patient.setPassword(encryptor.encryptPassword(pe.getNewPwd()));
            patientService.updatePassword(patient);
        }
        session.removeAttribute("patient");
        System.out.println("修改密码");
        return Map.of("success", true);
    }
}
