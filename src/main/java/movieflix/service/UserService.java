package movieflix.service;

import lombok.RequiredArgsConstructor;
import movieflix.entity.User;
import movieflix.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User userRegister(User user){
        return userRepository.save(user);
    }
}
