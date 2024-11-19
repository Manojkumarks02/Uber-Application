package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.DriverDto;
import com.KT.project.uber.uberApp.dto.SignUpDto;
import com.KT.project.uber.uberApp.dto.UserDto;
import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.User;
import com.KT.project.uber.uberApp.entity.enums.Role;
import com.KT.project.uber.uberApp.exception.ResourceNotFoundException;
import com.KT.project.uber.uberApp.exception.RuntimeConflictException;
import com.KT.project.uber.uberApp.repository.UserRepository;
import com.KT.project.uber.uberApp.security.JWTService;
import com.KT.project.uber.uberApp.service.AuthService;
import com.KT.project.uber.uberApp.service.DriverService;
import com.KT.project.uber.uberApp.service.RiderService;
import com.KT.project.uber.uberApp.service.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;


    @Override
    public String[] login(String email, String password) {
       Authentication authentication =  authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(email, password)
       );

       User user = (User) authentication.getPrincipal();

       String accessToken = jwtService.generateAccessToken(user);
       String refreshToken = jwtService.generateRefreshToken(user);

       return new String[]{accessToken,refreshToken};
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
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser );

        //creating user related entities
       riderService.createNewRider(savedUser);

       walletService.creatNewWallet(savedUser);

//        todo add wallet releated service
        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->new ResourceNotFoundException("user not found with id : " + userId));

        if (user.getRoles().contains(Role.DRIVER)){
            throw new RuntimeException("user with id" + userId +" is already a driver");
        }

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);

        return modelMapper.map(savedDriver, DriverDto.class);

    }

    @Override
    public String refreshToken(String refreshToken) {
        Long userId = jwtService.getUserIdFromToken(refreshToken);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found " +
                "with id: "+userId));

        return jwtService.generateAccessToken(user);
    }
}