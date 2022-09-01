package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void add(UserRequest request);

    List<User> findAll();

    Page<User> findAllPage(int page, int size);

    User findById(String id);

    void update(UserRequest request, String id);

    void delete(String id);
}
