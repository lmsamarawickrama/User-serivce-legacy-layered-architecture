package org.saliam.smartbids.config;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.mapper.UserMapper;
import org.saliam.smartbids.repository.UserRepository;
import org.saliam.smartbids.service.api.user.UserService;
import org.saliam.smartbids.service.impl.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration
{
  @Bean(name = "org.saliam.smartbids.service.api.user.UserService")
  public UserService getUserService(final UserRepository userRepository)
  {
    return new UserServiceImpl(userRepository, Mappers.getMapper(UserMapper.class));
  }
}
