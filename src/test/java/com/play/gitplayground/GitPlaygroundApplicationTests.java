package com.play.gitplayground;

import com.play.gitplayground.Repository.UserRepository;
import com.play.gitplayground.model.User;
import com.play.gitplayground.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class GitPlaygroundApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @MockBean           // It allows to mock a class or an interface and to record and verify behaviors on it.
    private UserRepository userRepository;

    @Test
    public void getUserTest() {
       when(userRepository.findAll()).thenReturn(Stream.of(
               new User(1234,"Daniel",23, "USA"),
               new User(958, "Andrew",57,"UK"))
               .collect(Collectors.toList()));
       assertEquals(2, userService.getUsers().size());
    }

}
