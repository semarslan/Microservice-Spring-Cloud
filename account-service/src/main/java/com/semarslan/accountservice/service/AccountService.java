package com.semarslan.accountservice.service;

import com.semarslan.client.contract.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {

    AccountDto getById(String id);

    AccountDto save(AccountDto accountDto);

    AccountDto update(String id, AccountDto accountDto);

    void delete(String id);

    Page<AccountDto> getAll(Pageable pageable);
}
