package springboot.snowone.practice.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcoountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);
}
