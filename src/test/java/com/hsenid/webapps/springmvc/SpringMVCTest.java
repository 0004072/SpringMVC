package com.hsenid.webapps.springmvc;

import com.hsenid.webapps.controller.LoginController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by hsenid on 4/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration("WebConfig")
public class SpringMVCTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void init(){
        this.mockMvc = webAppContextSetup(ctx).build();
    }

    @Configuration
    public static class TestConfig{
        @Bean
        public LoginController loginController(){
            return new LoginController();
        }
    }


    //Test Cases

    @Test
    public void testLogin() throws Exception{
        mockMvc.perform(get("/login.htm").accept(MediaType.TEXT_PLAIN))
                .andDo(print());
    }
}
