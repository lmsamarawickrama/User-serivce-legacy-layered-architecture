package org.saliam.smartbids.dto.user;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.dto.common.PageableDto;

import java.util.Set;

@Getter @Setter
public class UserDto implements PageableDto
{
  private Long id;

  private String username;

  private String email;

  private String password;

  private Set<RoleDto> roles;
}
