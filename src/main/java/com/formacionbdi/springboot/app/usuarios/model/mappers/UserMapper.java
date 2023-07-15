package com.formacionbdi.springboot.app.usuarios.model.mappers;

import com.formacionbdi.springboot.app.usuarios.model.User;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserDTO;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserRegister;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    User userDTOToUser(UserDTO userDTO);

    User userRegisterToUser(UserRegister userRegister);

    UserResponse userToUserResponse(User user);

}
