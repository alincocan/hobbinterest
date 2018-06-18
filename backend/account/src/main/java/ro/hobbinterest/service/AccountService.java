package ro.hobbinterest.service;

import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import ro.hobbinterest.entities.Account;

import java.util.List;

public interface AccountService {

    Account getById(String id);
    String createAccount(Account account);
    String deleteAccount(String id);
    String suspendAccount(String id);
    Page<Account> getAll(int page, int pageSize);

}
