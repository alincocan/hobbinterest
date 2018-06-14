package ro.hobbinterest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.hobbinterest.entities.Account;
import ro.hobbinterest.exceptions.AccountNotFoundException;
import ro.hobbinterest.exceptions.DuplicateAccountException;
import ro.hobbinterest.messages.ResourceBundle;
import ro.hobbinterest.repository.AccountRepository;

import java.util.Optional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ResourceBundle messages;
    private final String ACCOUNT_NOT_FOUND = "account_not_found";
    private final String ACCOUNT_CREATED = "account_created";
    private final String ACCOUNT_DELETED = "account_deleted";
    private final String ACCOUNT_SUSPENDED = "account_suspended";


    private AccountDuplicateChecker<String, String> accountDuplicateChecker = null;

    @Autowired
    public AccountServiceImpl(final AccountRepository accountRepository, final ResourceBundle messages) {
        this.accountRepository = accountRepository;
        this.messages = messages;
        accountDuplicateChecker = (email, entityId) -> {

            Optional<Account>existedAccount = accountRepository.findByEmail(email);
            if(!existedAccount.isPresent()) {
                if(entityId == null || existedAccount.get().getId().equalsIgnoreCase(entityId))
                    return true;
            }

            return false;
        };
    }

    @Override
    public Account getById(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()) throw new AccountNotFoundException(messages.getMessage(ACCOUNT_NOT_FOUND));
        return account.get();
    }

    @Override
    public String createAccount(Account account) {
        boolean isDuplicate = accountDuplicateChecker.checkDuplicate(account.getEmail(), account.getId());
        if(isDuplicate) throw new DuplicateAccountException("");
        accountRepository.save(account);
        return messages.getMessage(ACCOUNT_CREATED);
    }

    @Override
    public String deleteAccount(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()) throw new AccountNotFoundException(messages.getMessage(ACCOUNT_NOT_FOUND));

        accountRepository.delete(account.get());
        return messages.getMessage(ACCOUNT_DELETED);

    }

    @Override
    public String suspendAccount(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(!account.isPresent()) throw new AccountNotFoundException(messages.getMessage(ACCOUNT_NOT_FOUND));
        account.get().setSuspended(true);
        accountRepository.save(account.get());
        return messages.getMessage(ACCOUNT_SUSPENDED);
    }

    @Override
    public Page<Account> getAll(int page, int pageSize) {
        return accountRepository.findAll(PageRequest.of(page-1, pageSize));
    }
}
