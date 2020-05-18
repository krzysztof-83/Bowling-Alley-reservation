package pl.christopherk.BowlingAlley.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.christopherk.BowlingAlley.common.dto.UserDto;
import pl.christopherk.BowlingAlley.common.exceptions.UserNotFoundException;
import pl.christopherk.BowlingAlley.persistance.domain.UserEntity;
import pl.christopherk.BowlingAlley.persistance.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Set<UserDto> findAllUsers(){
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .map(this::convertoToDto)
                .collect(Collectors.toSet());
    }

    public UserDto findUserByEmail(UserDto userDto){
        return convertoToDto(userRepository.findUserByEmail(userDto.getEmail()).orElseThrow(() -> new UserNotFoundException(userDto.getName())));
    }

    public UserDto findUserByEmail(String emial){
        return convertoToDto(userRepository.findUserByEmail(emial).orElseThrow(() -> new UserNotFoundException(emial)));
    }

    private UserDto convertoToDto(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDto.class);
    }

    private UserEntity convertToEntity(UserDto userDto){
        return modelMapper.map(userDto, UserEntity.class);
    }


}
