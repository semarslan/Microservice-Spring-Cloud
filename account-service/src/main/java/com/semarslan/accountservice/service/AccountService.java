package com.semarslan.accountservice.service;

import com.semarslan.accountservice.entity.Account;

import java.util.List;

public interface AccountService {

    Account getById(String id);

    Account save(Account account);

    Account update(String id, Account account);

    void delete(String id);

    List<Account> findAll();
}
