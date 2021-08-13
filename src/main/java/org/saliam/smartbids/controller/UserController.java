package org.saliam.smartbids.controller;

import org.saliam.smartbids.dto.common.PageDto;
import org.saliam.smartbids.dto.user.UserCreateDto;
import org.saliam.smartbids.dto.user.UserDto;
import org.saliam.smartbids.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
  private UserService userService;

  @Autowired
  public void setUserService(UserService userService)
  {
    this.userService = userService;
  }

  @PostMapping(value = "/users")
  public UserDto save(UserCreateDto userCreateDto)
  {
    return userService.save(userCreateDto);
  }

  @GetMapping(value = "/users/{id}")
  public UserDto get(@PathVariable(name = "id") Long id)
  {
    return userService.getById(id);
  }

  @GetMapping(value = "/users")
  public PageDto<UserDto> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size)
  {
    return userService.getAll(page, size);
  }
}
