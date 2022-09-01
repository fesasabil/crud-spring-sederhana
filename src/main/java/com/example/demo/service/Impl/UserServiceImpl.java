package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void add(UserRequest request) {
        User entity = userMapper.fromRequest(request);
        userRepository.save(entity);
    }

    @Override
    public List<User> findAll() {
        return(List<User>) userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<User> findAllPage(int page, int size) {
        Pageable pageReq = PageRequest.of(page, size);
        return userRepository.findAll(pageReq);
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public void update(UserRequest request, String id) {
        if (id != null) {
            Optional<User> req1 = userRepository.findById(id);

            if (req1.get() != null) {
                User user = userMapper.fromRequest(request);

                user.setId(req1.get().getId());

                userRepository.save(user);
            }
        }
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
