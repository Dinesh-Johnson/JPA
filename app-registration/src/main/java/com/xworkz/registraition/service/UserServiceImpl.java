package com.xworkz.registraition.service;

import com.xworkz.registraition.dto.UserDTO;
import com.xworkz.registraition.entity.UserEntity;
import com.xworkz.registraition.repository.UserRepo;
import com.xworkz.registraition.utill.OTPUtill;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private EmailSender sender;

    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private Map<String,Integer> attempts= new HashMap<>();


    @Override
    public boolean save(UserDTO dto) {
        System.out.println("save method: ");
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(dto,entity);
        String otp = OTPUtill.generateNumericOtp(6);
        entity.setPassword(encoder.encode(otp));
        entity.setExpiryTime(null);
        entity.setLoginCount(-1);
        entity.setPresent(true);
        if (repo.save(entity)){
            if (sender.mailSend(dto.getEmail(), otp)){

                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public UserDTO acceptLogin(String email, String password) {

        UserEntity entity = repo.acceptLogin(email);

        if (entity==null){
            return null;
        }
        if (entity.getLoginCount()==-1){
            if (entity.getPassword().equals(password)){

                UserDTO dto = new UserDTO();
                BeanUtils.copyProperties(entity,dto);
                return dto;
            }

        }
        if (entity.getExpiryTime()!=null && entity.getExpiryTime().isAfter(LocalDateTime.now())) {
            throw new RuntimeException("Account Locked Try after Some Time"+entity.getExpiryTime());

        }
        if (encoder.matches(password,entity.getPassword())){
            attempts.put(email,0);
            entity.setExpiryTime(null);
            repo.lockTimeUpdate(entity);
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(entity, dto);
            System.out.println("SERVICE fetch by Login:" + entity);
            return dto;
        }
        else {
            int count = attempts.getOrDefault(email,0)+1;
            attempts.put(email,count);

            if (count>3){

                entity.setExpiryTime(LocalDateTime.now().plusMinutes(2));
                repo.lockTimeUpdate(entity);
                attempts.put(email,0);
                throw new RuntimeException("Account Locked For  2 Minutes");
            }
            return null;
        }
    }

    @Override
    public String getByEmail(String mail) {
        System.out.println("GET MAIL SERVICE");
        return repo.getByMail(mail);
    }

    @Override
    public Long getByMobile(Long mobile) {
        System.out.println("GET Mobile SERVICE");
        return repo.getByMobile(mobile);
    }

    @Override
    public boolean acceptLoginByOtp(String email, String userOtp) {
        System.out.println("Accept by OTP");
        String encodedOtp = repo.getPassword(email);
        System.out.println("Pass for otp "+ encodedOtp);
        if (encodedOtp == null || encodedOtp.isEmpty()) {
            System.out.println("No OTP found for email: " + email);
            return false;
        }
        return encoder.matches(userOtp, encodedOtp);
    }

    @Override
    public boolean resetPassword(String email, String password, String confirmPassword) {
        System.out.println("Reset Password Service......");
        if (password.equals(confirmPassword)) {
            String encoded = encoder.encode(password);
            if (repo.resetPassword(email, encoded)) {
                return true;
            }
        }
        return false;
    }
}
