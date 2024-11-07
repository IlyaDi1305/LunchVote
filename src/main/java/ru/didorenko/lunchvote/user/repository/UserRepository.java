package ru.didorenko.lunchvote.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.didorenko.lunchvote.app.config.SecurityConfig;
import ru.didorenko.lunchvote.common.BaseRepository;
import ru.didorenko.lunchvote.common.error.NotFoundException;
import ru.didorenko.lunchvote.user.model.User;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User> {
    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    Optional<User> findByEmailIgnoreCase(String email);

    @Transactional
    default User prepareAndSave(User user) {
        user.setPassword(SecurityConfig.PASSWORD_ENCODER.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return save(user);
    }

    default User getExistedByEmail(String email) {
        return findByEmailIgnoreCase(email).orElseThrow(() -> new NotFoundException("User with email=" + email + " not found"));
    }
}