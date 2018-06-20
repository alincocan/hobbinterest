package ro.hobbinterest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.hobbinterest.entities.Account;
import ro.hobbinterest.response.ResponseEntity;
import ro.hobbinterest.service.AccountService;

import javax.validation.Valid;
import java.util.stream.Collectors;

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
    public Object createAccount(@Valid @RequestBody Account account, Errors errors) {
        if(errors.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.value(), errors.getAllErrors().stream().map(x -> x.getDefaultMessage()));
        }
        return new ResponseEntity<>(HttpStatus.OK.value(), accountService.createAccount(account));
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Object getAccounts(@RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize) {
        return accountService.getAll(page, pageSize);
    }


    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public Object getAccountById(@RequestParam(name = "id") String id) {
        return accountService.getById(id);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Object deleteAccount(@RequestParam(name = "id") String id) {
        return new ResponseEntity<>(HttpStatus.OK.value(), accountService.deleteAccount(id));
    }

    @RequestMapping(value = "suspend", method = RequestMethod.PATCH)
    public Object suspendAccount(@RequestParam(name = "id") String id) {
        return new ResponseEntity<>(HttpStatus.OK.value(), accountService.suspendAccount(id));
    }
}
