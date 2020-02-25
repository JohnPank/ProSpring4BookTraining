package com.johnpank.prospring4.chapter13.service;

import com.johnpank.prospring4.chapter13.config.TestAppConfig;
import com.johnpank.prospring4.chapter13.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestAppConfig.class, loader = AnnotationConfigContextLoader.class)
//@TestExecutionListeners({ServiceTestExecutionListener.class})
class UserServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserService userService;

    @Sql(scripts = "/cleanTable.sql")
    @Test
    void save() {

        User tempUser = new User();
        tempUser.setName("testUserName");
        tempUser.setPassword("testPassword");
        tempUser.setEmail("test@email.com");
        tempUser = userService.save(tempUser);

        assertNotNull(tempUser.getId());
    }

    //@DataSets(setUpDataSet = "/home/johnpank/JavaProject/ProSpring4/chapter13/src/test/java/com/johnpank/prospring4/chapter13/service/dbEmul.xls")
    @Sql(scripts = "/resetTable.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            statements = "insert into users(name, password, email) values ('testUser1', 'testPassword1', 'test1@email.com');")
    @Sql(scripts = "/cleanTable.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    void findById() {
        User user = userService.findById(1l);
        assertNotNull(user);
    }

    //@DataSets(setUpDataSet = "/src/test/java/com/johnpank/prospring4/chapter13/service/dbEmul.xls")
//    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
//            statements = "insert into users(name, password, email) values ('testUser1', 'testPassword1', 'test1@email.com');" +
//                    "insert into users(name, password, email) values ('testUser2', 'testPassword2', 'test2@email.com');" +
//                    "insert into users(name, password, email) values ('testUser3', 'testPassword3', 'test3@email.com');")
    @Sql(scripts = "/testData.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanTable.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    @DisplayName("Test findAll")
    void findAll() {
        List<User> users = userService.findAll();
        System.out.println(users.size());
        assertEquals(3, users.size());
    }

    @Test
    void delete() {
    }

//    @Sql(scripts = "/testData.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//    @Sql(scripts = "/cleanTable.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//    @Test
//    void findByName() {
//        User user = userService.findByName("testUser2");
//        assertNotNull(user);
//    }
}