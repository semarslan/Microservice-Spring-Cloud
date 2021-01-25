package com.semarslan.client;

import com.semarslan.client.contract.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface AccountServiceClient {

    @RequestMapping("/account/{id}")
    ResponseEntity<AccountDto> getById(@PathVariable String id);
}
