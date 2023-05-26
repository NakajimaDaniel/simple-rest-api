package com.example.simplerestapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplerestapi.User;
import com.example.simplerestapi.Services.UserServices;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

  @Autowired
  private UserServices service;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> findAll() {
    return service.findAll();

  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public User findById(@PathVariable Long id) {
    return service.findById(id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public User create(@RequestBody User user) {
    return service.create(user);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public User update(@RequestBody User user) {
    return service.create(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();

  }

}
