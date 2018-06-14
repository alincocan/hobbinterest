package ro.hobbinterest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.hobbinterest.entities.Account;
import ro.hobbinterest.response.ResponseEntity;
import ro.hobbinterest.service.AccountService;

/**
 *
 */

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Object createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return new ResponseEntity<String>(HttpStatus.OK.value());
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Object getAccounts(@RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize) {
        return accountService.getAll(page, pageSize);
    }


    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public Object getAccountById(@RequestParam(name = "id") String id) {
        return accountService.getById(id);
    }

}
