package com.lihang.aopstudy;

import com.lihang.aopstudy.service.MyService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    MyService myService;
    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;
    @Before
    public void before(){
        System.out.println("mockMvc");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

  /*  @org.junit.Before
    public void before2(){
        System.out.println("通用方法：before");
    }
    @org.junit.After
    public void after2(){
        System.out.println("通用方法：after");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("通用方法：beforeClass");
    }
    @AfterClass
    public static void afterClasls(){
        System.out.println("通用方法：afterClass");
    }*/
    @Test
        public void contextLoads() throws Exception {
            System.out.println(mockMvc);
            MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/aop/success")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(MockMvcResultMatchers.status().isOk())

                .andReturn();
    }

    @Test
    public void contextLoads2() throws Exception {
        System.out.println(mockMvc);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/aop/error")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void testPointCut(){
        myService.getById(1);
    }

}
