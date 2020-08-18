package com.it.nacos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/08/17 16:32
 */
public class PwdUtil {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("nacos"));
    }
}
