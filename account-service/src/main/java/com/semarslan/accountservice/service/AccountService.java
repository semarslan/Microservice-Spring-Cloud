package com.semarslan.accountservice.service;

import com.semarslan.accountservice.dto.AccountDto;
import com.semarslan.accountservice.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {

    AccountDto getById(String id);

    AccountDto save(AccountDto accountDto);

    AccountDto update(String id, AccountDto accountDto);

    void delete(String id);

    Page<AccountDto> getAll(Pageable pageable);
}
