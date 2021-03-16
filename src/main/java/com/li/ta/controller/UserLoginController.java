package com.li.ta.controller;

import com.li.ta.common.LoginRSA;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;

//@Api(tags = "")
@RestController("userLoginController")
@RequestMapping(value = "/user-login")
public class UserLoginController {

    @GetMapping
//    @ApiOperation(value = "登录")
    public String userLogin() throws Exception {
        KeyPair keyPair = LoginRSA.getKeyPair();

        String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
        String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));

        String passwd = LoginRSA.encrypt("123123", LoginRSA.getPublicKey(publicKey));
        String decrypt = LoginRSA.decrypt(passwd, LoginRSA.getPrivateKey(privateKey));

        return "passwd \t " + passwd + "\npublicKey \t" + publicKey;
    }
}
