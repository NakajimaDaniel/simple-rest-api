package com.example.simplerestapi.Services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplerestapi.User;
import com.example.simplerestapi.Controller.ApiController;
import com.example.simplerestapi.Repository.UserRepository;

@Service
public class UserServices {

  @Autowired
  UserRepository repository;

  public List<User> findAll() {
    var users = repository.findAll();

    users.stream().forEach(p -> p.add(linkTo(methodOn(ApiController.class).findById(p.getId())).withSelfRel()));
    return users;
  }

  public User findById(Long id) {
    return repository.findById(id).orElseThrow(null);
  }

  public User create(User user) {
    return repository.save(user);
  }

  public User update(User user) {
    User entity = repository.findById(user.getId()).orElseThrow(null);
    entity.setFirstName(user.getFirstName());
    entity.setLastName(user.getLastName());
    entity.setEmail(user.getEmail());
    entity.setGender(user.getGender());
    return repository.save(user);
  }

  public void delete(Long id) {
    User entity = repository.findById(id).orElseThrow(null);
    repository.delete(entity);

  }

}
