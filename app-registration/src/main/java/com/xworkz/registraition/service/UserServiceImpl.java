package com.xworkz.registraition.service;

import com.xworkz.registraition.dto.UserDTO;
import com.xworkz.registraition.entity.UserEntity;
import com.xworkz.registraition.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public boolean save(UserDTO dto) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(dto,entity);
        entity.setPassword(encoder.encode(dto.getPassword()));
        return repo.save(entity);
    }

    @Override
    public UserDTO acceptLogin(String email, String password) {

        UserEntity entity = repo.acceptLogin(email);

        if (entity == null) {
            return null;
        }
        if (!encoder.matches(password, entity.getPassword())) {
            return null;
        }
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(entity, dto);
        System.out.println("SERVICE fetch by Login:" + entity);
        return dto;
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
}
