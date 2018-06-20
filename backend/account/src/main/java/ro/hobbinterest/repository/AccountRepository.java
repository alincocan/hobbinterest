package ro.hobbinterest.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ro.hobbinterest.entities.Account;

import java.util.List;
import java.util.Optional;

@EnableScan
@EnableScanCount
public interface AccountRepository extends CrudRepository<Account, String> , PagingAndSortingRepository<Account, String> {

    List<Account> findByEmail(String email);
}
