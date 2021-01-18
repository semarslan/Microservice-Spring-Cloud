package com.semarslan.accountservice.api;

import com.semarslan.accountservice.dto.AccountDto;
import com.semarslan.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping()
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(accountService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping
    public void delete(String id) {

        accountService.delete(id);
    }
}
