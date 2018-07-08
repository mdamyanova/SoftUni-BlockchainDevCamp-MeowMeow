package com.meowmeow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeowMeowApplication {
    public static void main(String[] args) throws Exception {
        //String provider = "";
        //String privateKey = "";
        //ContractService service = new ContractService(provider, privateKey);
        SpringApplication.run(MeowMeowApplication.class, args);
    }
}