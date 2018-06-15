package ro.hobbinterest.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ro.hobbinterest.entities.Account;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository("accountRepository")
public interface AccountRepository {

    Optional<Account> findByEmail(String email);
}
