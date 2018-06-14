package ro.hobbinterest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.hobbinterest.entities.Account;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, String>, PagingAndSortingRepository<Account, String> {

    Optional<Account> findByEmail(String email);
}
