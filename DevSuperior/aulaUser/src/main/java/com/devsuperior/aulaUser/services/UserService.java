package com.devsuperior.aulaUser.services;

import com.devsuperior.aulaUser.dto.UserDTO;
import com.devsuperior.aulaUser.entities.User;
import com.devsuperior.aulaUser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User entity = repository.findById(id).get();
        UserDTO dto = new UserDTO(entity);
        return dto;
    }
}
