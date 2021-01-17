package com.semarslan.accountservice.service.impl;

import com.semarslan.accountservice.entity.Account;
import com.semarslan.accountservice.repository.AccountRepository;
import com.semarslan.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Account getById(String id) {
        /**
         * bulursa datanın kendisini, bulamazsa hata ver.
         */
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Account update(String id, Account account) {
        Assert.isNull(id, "Id cannot be null");
        return accountRepository.save(account);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public void delete(String id) {

    }
}
