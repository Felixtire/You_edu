package com.mvpyouedu.YouEdu_api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncoderService {

    @Autowired
    private PasswordEncoder encoder;



    public String encoder(String senha){
        return encoder.encode(senha);
    }
}
