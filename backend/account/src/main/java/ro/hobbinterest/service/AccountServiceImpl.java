package ro.hobbinterest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.hobbinterest.entities.Account;
import ro.hobbinterest.exceptions.AccountNotFoundException;
import ro.hobbinterest.messages.ResourceBundle;
import ro.hobbinterest.repository.AccountRepository;

import java.util.Optional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ResourceBundle messages;
    private final String ACCOUNT_NOT_FOUND = "account_not_found";

    @Autowired
    public AccountServiceImpl(final AccountRepository accountRepository, final ResourceBundle messages) {
        this.accountRepository = accountRepository;
        this.messages = messages;
    }

    @Override
    public Account getById(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()) throw new AccountNotFoundException(messages.getMessage(ACCOUNT_NOT_FOUND));
        return account.get();
    }

    @Override
    public void createAccount(Account account) {

        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()) throw new AccountNotFoundException(messages.getMessage(ACCOUNT_NOT_FOUND));

        accountRepository.delete(account.get());
    }

    @Override
    public void suspendAccount(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()) throw new AccountNotFoundException(messages.getMessage(ACCOUNT_NOT_FOUND));

        account.get().setSuspended(true);

        accountRepository.save(account.get());
    }

    @Override
    public Page<Account> getAll(int page, int pageSize) {
        return accountRepository.findAll(PageRequest.of(page-1, pageSize));
    }
}
