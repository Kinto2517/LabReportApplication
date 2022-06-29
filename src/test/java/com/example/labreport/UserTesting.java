package com.example.labreport;

import com.example.labreport.business.services.UserService;
import com.example.labreport.dao.UserRepository;
import com.example.labreport.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTesting {

    @Autowired
    private UserRepository userRepository;

    private User user = new User();


    @BeforeEach
    public void setUp() {
        user.setUsername("test");
        user.setPassword("test");
        user.setRole("test");
        user.setName("test");
        user.setSurname("test");
        user.setId(1L);

        userRepository.save(user);
    }


    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateUser() {
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser);
    }


    @Test
    @Order(2)
    public void testGetUserById() {

        Long id = 1L;
        User user = userRepository.findById(id).get();
        assertThat(user.getId()).isEqualTo(id);

    }

    @Test
    @Order(3)
    public void testGetAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        assertThat(users.size()).isEqualTo(1);
    }


    @Test
    @Order(5)
    public void testDeleteUser() {
        Long id = 1L;
        userRepository.deleteById(id);
        assertThat(userRepository.findById(id)).isEqualTo(Optional.empty());
    }

    @Test
    @Order(4)
    public void testUpdateUser() {
        User user = userRepository.findById(1L).get();
        user.setUsername("test2");
        user.setPassword("test2");
        user.setRole("test2");
        user.setName("test2");
        user.setSurname("test2");
        userRepository.save(user);
        User user2 = userRepository.findById(1L).get();
        assertThat(user2.getUsername()).isEqualTo("test2");
        assertThat(user2.getPassword()).isEqualTo("test2");
        assertThat(user2.getRole()).isEqualTo("test2");
        assertThat(user2.getName()).isEqualTo("test2");
        assertThat(user2.getSurname()).isEqualTo("test2");
    }

}
