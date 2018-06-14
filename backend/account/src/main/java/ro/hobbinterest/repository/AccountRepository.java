package ro.hobbinterest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ro.hobbinterest.entities.Account;

import java.awt.print.Pageable;
import java.util.List;


public interface AccountRepository extends CrudRepository<Account, String>, PagingAndSortingRepository<Account, String> {

}
