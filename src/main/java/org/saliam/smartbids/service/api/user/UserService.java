package org.saliam.smartbids.service.api.user;

import org.saliam.smartbids.dto.common.PageDto;
import org.saliam.smartbids.dto.user.UserCreateDto;
import org.saliam.smartbids.dto.user.UserDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserService
{
  @Transactional
  UserDto save(UserCreateDto userDto);

  UserDto getById(Long id);

  PageDto<UserDto> getAll(int page, int size);
}
