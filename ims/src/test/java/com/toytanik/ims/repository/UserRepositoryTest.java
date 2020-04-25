package com.toytanik.ims.repository;

import com.toytanik.ims.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    protected void setup() throws  Exception{

    }

    @Test
    public void  shouldFindAllUsers() {
      Iterable<User> user = userRepository.findAll();
      assertThat(user).isNotEmpty();
    }

    @Test
    public void shouldFindUserWithId(){
        User user = userRepository.findAllById(1L);
        assertThat(user).isNotNull();
        assertFalse(user.getName().isEmpty());
    }

    @Test
    public void shouldReturnYesWhenCreateUserWithSameEmail() {
        User user = new User();
        user.setName("Tuncay");
        user.setSurname("Turk");
        user.setEmail("tuncayturk.cse@gmail.com");
        userRepository.save(user);

        assertThat(userRepository.existsByEmail("tuncayturk.cse@gmail.com")).isTrue();
    }


}
