package org.saliam.smartbids.service.impl.user;

import org.saliam.smartbids.dto.common.PageDto;
import org.saliam.smartbids.dto.user.UserCreateDto;
import org.saliam.smartbids.dto.user.UserDto;
import org.saliam.smartbids.entity.User;
import org.saliam.smartbids.mapper.UserMapper;
import org.saliam.smartbids.repository.UserRepository;
import org.saliam.smartbids.service.api.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;

  private final UserMapper userMapper;

  public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper)
  {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  @Transactional
  public UserDto save(final UserCreateDto userDto)
  {
    User user = userMapper.userCreateDtoToUser(userDto);
    return userMapper.userToUserDto(userRepository.save(user));
  }

  @Override
  public UserDto getById(final Long id)
  {
    User userById = userRepository.getById(id);
    return userMapper.userToUserDto(userById);
  }

  @Override
  public PageDto<UserDto> getAll(int page, int size)
  {
    Page<User> userPage = userRepository.findAll(PageRequest.of(page, size));
    List<UserDto> userDtoS = userPage.getContent().stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    return new PageDto<>(userDtoS, userPage.getTotalPages(), userDtoS.size());
  }
}
