package com.github.felipemartins152.consolidator.service.user;

import com.github.felipemartins152.consolidator.domain.User;
import com.github.felipemartins152.consolidator.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserRepository userRepository;

    @Transactional
    public void removeAccount(Long id){
        User user = userRepository.findByUserIdAndIsActive(id, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado."));

        user.setActive(false);

        userRepository.save(user);
    }

}