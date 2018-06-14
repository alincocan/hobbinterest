package ro.hobbinterest.service;

import org.springframework.data.domain.Page;
import ro.hobbinterest.entities.Account;

import java.util.List;

public interface AccountService {

    Account getById(String id);
    void createAccount(Account account);
    void deleteAccount(String id);
    void suspendAccount(String id);
    Page<Account> getAll(int page, int pageSize);

}
