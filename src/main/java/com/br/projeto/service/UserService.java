package com.br.projeto.service;


import com.br.projeto.domain.User;
import com.br.projeto.domain.UserEntity;
import com.br.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public String save(User user){
        var userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setProfession(user.getProfession());
        var usr = userRepository.save(userEntity);
        return usr.toString();
    }

    public Object findByName(String name){
        return userRepository.findByName(name);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public Object update(User user){

        var optionalUserEntity = userRepository.findById(user.getId());
        if (optionalUserEntity.isPresent()){
            var entity = optionalUserEntity.get();
            entity.setName(user.getName());
            entity.setAge(user.getAge());
            entity.setProfession(user.getProfession());
            var response = userRepository.save(entity);
            return response;
        }

        return "user not found";
    }

}
