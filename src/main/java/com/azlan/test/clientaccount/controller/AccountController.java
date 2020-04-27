package com.azlan.test.clientaccount.controller;

import com.azlan.test.clientaccount.model.Account;
import com.azlan.test.clientaccount.model.ResponseModel;
import com.azlan.test.clientaccount.model.entity.AccountEntity;
import com.azlan.test.clientaccount.service.ifc.AccountServiceIfc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/accounts")  // API GW will take care of API versioning
@Api(value="Account Management System")
public class AccountController {

    private final AccountServiceIfc accountServiceIfc;

    public AccountController(AccountServiceIfc accountServiceIfc) {
        this.accountServiceIfc = accountServiceIfc;
    }

    @ApiOperation(value = "View a list of accounts", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  Iterable<AccountEntity> getAllAccounts(){
        log.debug("Get all accounts");
        return accountServiceIfc.getAllAccounts();
    }

    @GetMapping(path = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<AccountEntity>> getAccountByClientId(@PathVariable("clientId") final Long clientId) {
        log.debug("Get account by client ID: " + clientId);
        List<AccountEntity> account = accountServiceIfc.getAccountByClientId(clientId);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping(path = "/addAccount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        log.debug("Creating account");
        
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountName(account.getAccountName());
        accountEntity.setClientId(account.getClientId());
        accountServiceIfc.addAccount(accountEntity);

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping(value = "/healthCheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> healthCheck(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(new Date(), "I'm alive", ""));
    }
}
