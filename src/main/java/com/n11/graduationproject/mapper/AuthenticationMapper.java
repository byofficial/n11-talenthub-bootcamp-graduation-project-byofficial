package com.n11.graduationproject.mapper;

import com.n11.graduationproject.dto.request.CreateUserDto;
import com.n11.graduationproject.dto.request.LoginDto;
import com.n11.graduationproject.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthenticationMapper {
    AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);

    //1.a Kullanıcı kaydeden servis yazın
    User convertCreateUserDtoToUser(CreateUserDto userDto);

    //Kullanıcı girişi
    User convertLoginDtoToUser(LoginDto loginDto);
}
