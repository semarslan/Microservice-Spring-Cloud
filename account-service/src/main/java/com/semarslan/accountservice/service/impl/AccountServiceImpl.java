package com.semarslan.accountservice.service.impl;

import com.semarslan.accountservice.entity.Account;
import com.semarslan.accountservice.repository.AccountRepository;
import com.semarslan.accountservice.service.AccountService;
import com.semarslan.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    @Override
    public Page<AccountDto> getAll(Pageable pageable) {
        /**
         * Slice Page sınıf yerine.
         */
        Slice<Account> accounts = accountRepository.findAll(pageable);
        return null;
    }

    @Override
    public AccountDto getById(String id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);
        return modelMapper.map(account, AccountDto.class);

    }

    @Override
    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Override
    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> account = accountRepository.findById(id);
        Account accountUpdate = account.map(item -> {
                    item.setBirthDate(accountDto.getBirthDate());
                    item.setName(accountDto.getName());
                    item.setSurname(accountDto.getSurname());
                    return item;
                }).orElseThrow(IllegalAccessError::new);
        return modelMapper.map(accountRepository.save(accountUpdate), AccountDto.class);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);
        accountRepository.delete(account);
    }
}
