package com.javastudio.web.api.v1;

import com.javastudio.api.PayStubItemService;
import com.javastudio.api.PayStubService;
import com.javastudio.dto.Employee;
import com.javastudio.dto.PayStub;
import com.javastudio.dto.PayStubItem;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/paystubitems")
public class PayStubItemResource {

    private final Logger logger;

    @Autowired
    private PayStubItemService payStubItemService;

    public PayStubItemResource(Logger logger) {
        this.logger = logger;
    }

    @GetMapping
    public ResponseEntity<List<PayStubItem>> findAll(@RequestParam("payStubId") Optional<Long> payStubId, @RequestParam("applyYearMonth") Optional<String> applyYearMonth) {
        return ResponseEntity.ok(payStubItemService.findAll(payStubId, applyYearMonth));
    }
}
