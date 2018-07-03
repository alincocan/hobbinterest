package unit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ro.hobbinterest.SpringConfiguration;
import ro.hobbinterest.entities.Account;
import ro.hobbinterest.messages.ResourceBundle;
import ro.hobbinterest.repository.AccountRepository;
import ro.hobbinterest.service.AccountService;
import ro.hobbinterest.service.AccountServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@WebAppConfiguration
@ActiveProfiles("local")
public class AccountUnitTest {

    private String accountId = "1232132131123121";
    private String accountEmail = "test@email.com";
    private String firstName = "firstName";
    private String lastName = "lastName";
    private int page = 1;
    private int pageSize = 10;



    @InjectMocks
    private AccountService accountService;

    Supplier<Account> accountSupplier = () -> {
        Account account = new Account();
        account.setId(accountId);
        account.setEmail(accountEmail);
        account.setFirstName(firstName);
        account.setLastName(lastName);

        return account;
    };

    Supplier<Page<Account>> accontsListSupplier = () -> {
        List<Account> list = IntStream.range(1,10).boxed().map(elem -> {
            Account account = accountSupplier.get();
            account.setId(elem.toString());
            return account;
        }).collect(Collectors.toList());

        return new PageImpl<Account>(list);
    };
    @Before
    public void setUp() {

        ResourceBundle messages = mock(ResourceBundle.class);;
        AccountRepository accountRepository = mock(AccountRepository.class);;
        accountService = new AccountServiceImpl(accountRepository, messages);
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(accountSupplier.get()));
        when(accountRepository.findAll(PageRequest.of(page-1, pageSize))).thenReturn(accontsListSupplier.get());

    }

    @Test
    public void getAccountById_Test() {
        Account account = accountService.getById(this.accountId);

        assertNotNull(account);
        assertEquals(account.getId(), accountId);
        assertEquals(account.getEmail(), accountEmail);
        assertEquals(account.getFirstName(), firstName);
        assertEquals(account.getLastName(), lastName);

    }

    @Test
    public void getAll_Test() {
        Page<Account> accounts = accountService.getAll(page, pageSize);
        List<Account> accountList = accounts.getContent();

        assertEquals(accountList.size(), pageSize);

    }
}
