package com.johnpank.prospring4.chapter13.controllers;

import com.johnpank.prospring4.chapter13.entity.User;
import com.johnpank.prospring4.chapter13.service.UserService;
import org.aopalliance.intercept.Invocation;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MainControllerTest {

    private final List<User> users = new ArrayList<>();

    @Before
    void setUp() {
        User user = new User();
        user.setId(5l);
        user.setName("test user");
        user.setPassword("test password");
        user.setEmail("test email");
        users.add(user);
    }

    @Test
    void testGetAllUsers() {
        //создание имитации (заглушки) сервиса
        UserService userService = mock(UserService.class);
        //когда происходит обрашение к методу userService.findAll() вернуть список users
        when(userService.findAll()).thenReturn(users);

        MainController mainController = new MainController();
        //заменить в mainController поле "userService" на заглушку userService
        ReflectionTestUtils.setField(mainController, "userService", userService);
        //имитация страницы на которую отправляется ответ
        ExtendedModelMap uiModel = new ExtendedModelMap();
        //отправка ответа на имитацию страницы
        uiModel.addAttribute("userList",mainController.getAllUsers());
        //получение того что было отправлено на страницу
        ModelAndView usersFromModel = (ModelAndView) uiModel.get("userList");
        //сравнение
        assertEquals(1, usersFromModel.getModel().size());
    }

    @Test
    public void testAddUser(){
         final User newUser = new User();
         newUser.setId(100000l);
         //uncomment for check empty
         //newUser.setName("");
         newUser.setName("User for Test");
         newUser.setEmail("uft@post.com");
         newUser.setPassword("testPassword");

         UserService userService = mock(UserService.class);
         when(userService.save(newUser)).thenAnswer(new Answer<User>() {
             public User answer(InvocationOnMock invocation) throws Throwable{
                 users.add(newUser);
                 return newUser;
             }
         });

        MainController mainController = new MainController();
        ReflectionTestUtils.setField(mainController, "userService", userService);
        //System.out.println(newUser);
        String result = mainController.addUser(newUser);
        //System.out.println(result);
        assertEquals("User saved!", result);
        //assertEquals(2, users.size());
    }
}

/*

*/