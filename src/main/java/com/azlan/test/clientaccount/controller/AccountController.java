package com.azlan.test.clientaccount.controller;

import com.azlan.test.clientaccount.exception.ResourceNotFoundException;
import com.azlan.test.clientaccount.model.Account;
import com.azlan.test.clientaccount.service.ifc.AccountServiceIfc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Api(value="Account Management System")
public class AccountController {

    @Autowired
    private AccountServiceIfc accountServiceIfc;

    @ApiOperation(value = "View a list of accounts", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(path = "/accounts")
    public  Iterable<Account> getAllAccounts(){
        log.debug("Get all accounts");
        return accountServiceIfc.getAllAccounts();
    }

    @GetMapping(path = "/accounts/{clientId}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable("clientId") final Long clientId) throws ResourceNotFoundException {
        log.debug("Get account by client ID: " + clientId);
        Optional<Account> account = accountServiceIfc.getAccount(clientId);
        if(!account.isPresent())
            throw new ResourceNotFoundException("Account for client ID " + clientId + " is not found");

        return ResponseEntity.ok().body(account);
    }
}
