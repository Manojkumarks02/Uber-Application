package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.DriverDto;
import com.KT.project.uber.uberApp.dto.SignUpDto;
import com.KT.project.uber.uberApp.dto.UserDto;
import com.KT.project.uber.uberApp.entity.User;
import com.KT.project.uber.uberApp.entity.enums.Role;
import com.KT.project.uber.uberApp.exception.RuntimeConflictException;
import com.KT.project.uber.uberApp.repository.UserRepository;
import com.KT.project.uber.uberApp.service.AuthService;
import com.KT.project.uber.uberApp.service.RiderService;
import com.KT.project.uber.uberApp.service.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;
    private final WalletService walletService;


    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    @Transactional
    public UserDto signUp(SignUpDto signUpDto) {
        User user =userRepository.findByEmail(signUpDto.getEmail()).orElse(null);
        if(user != null){
            throw new RuntimeConflictException("cannot sign up , User already exists with email"+ signUpDto.getEmail());
        }

        User mappedUser = modelMapper.map(signUpDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser );

        //creating user related entities
       riderService.createNewRider(savedUser);

       walletService.creatNewWallet(savedUser);

//        todo add wallet releated service
        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
