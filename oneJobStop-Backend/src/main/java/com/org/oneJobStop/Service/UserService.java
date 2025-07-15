package com.org.oneJobStop.Service;

import com.org.oneJobStop.DTO.UserSignup;
import com.org.oneJobStop.Model.User;
import com.org.oneJobStop.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class UserService {

    public UserRepository userRepository;

    public BCryptPasswordEncoder bCryptPasswordEncoder;
    public EmailService emailService;


    public String signUp(UserSignup userDto) {
        String email = userDto.getEmail();
        String phoneNumber = userDto.getPhoneNumber();
        if(userRepository.findByEmail(email) && userRepository.findByPhoneNo(phoneNumber))
            return "This user is already registered";
        String password=bCryptPasswordEncoder.encode(userDto.getPassword());
        String otp= generateOTP();
        emailService.sendOTP(email,otp);
        User user=User.builder()
                .email(email)
                .phoneNo(phoneNumber)
                .name(userDto.getName())
                .password(password)
                .role(userDto.getRole())
                .otp(otp).build();
       userRepository.save(user);
       return "User registered";
    }

    private String generateOTP() {
        Random rand = new Random();
        int otp= 100000+rand.nextInt(90000);
        return String.valueOf(otp);
    }

    public String VerifyOTP(String otp) {
        return "OTP verified";
    }
}
