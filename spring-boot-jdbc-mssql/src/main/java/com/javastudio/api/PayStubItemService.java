package com.javastudio.api;

import com.javastudio.dto.PayStubItem;

import java.util.List;
import java.util.Optional;

public interface PayStubItemService {
    List<PayStubItem> findAll(Optional<Long> payStubId, Optional<String> applyYearMonth);
}
