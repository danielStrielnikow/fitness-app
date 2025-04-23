package pl.fitness.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fitness.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email);
}
