package com.ustyn.courseproject.dto;

import com.ustyn.courseproject.constants.Roles;
import com.ustyn.courseproject.document.user.Role;
import com.ustyn.courseproject.document.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String id;

    @Email(message = "неправильний формат")
    @NotBlank(message = "обов'язково")
    private String username = "";

    @NotBlank(message = "обов'язково")
    private String password = "";

    private boolean enabled = true;
    private String role = Roles.ROLE_GUEST.getValue();

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword().getPassword();
        this.enabled = user.isEnabled();
        this.role = user.getRoles().getFirst().getName();
    }
}
