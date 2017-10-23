package com.qt.shiro.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qt.shiro.entity.User;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("md5")
    private String algorithmName = "md5";
    @Value("1")
    private int hashIterations = 1;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {

//        user.setSalt(randomNumberGenerator.nextBytes().toHex());
    	user.setSalt(ByteSource.Util.bytes(user.getUsername()).toString());
    	
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
//                ByteSource.Util.bytes(user.getCredentialsSalt()),
                null,
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
    
    public static void main(String[] args) {
//    	PasswordHelper pa =new PasswordHelper();
//    	String salt = ByteSource.Util.bytes("admin").toString();
//    	System.out.println(salt);
//    	String credentials ="admin"+salt;
    	String newPassword = new SimpleHash(
                  "md5",
                 "123456",
                  null,
                  1).toHex();
    	System.out.println(newPassword);
	}
}
