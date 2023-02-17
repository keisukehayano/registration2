package com.example.registration2;

import java.util.Arrays;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegistrationController {
    
    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute RegistData registData, ModelAndView mv) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 名前 : " + registData.getName());
        sb.append(",パスワード : " + registData.getPassword());
        sb.append(",性別 : " + registData.getGender());
        sb.append(",地域 : " + registData.getArea());
        sb.append(",興味のある分野 : " + Arrays.toString(registData.getInterest()));
        sb.append(",興味のある分野 : " + registData.getRemarks().replaceAll("\n", ""));

        mv.setViewName("result");
        mv.addObject("resultData", sb.toString());
        return mv;
    }
}
