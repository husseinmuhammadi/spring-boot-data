package com.javastudio.service;

import com.javastudio.api.PayStubItemService;
import com.javastudio.dto.PayStubItem;
import com.javastudio.mapper.PayStubItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PayStubItemServiceImpl implements PayStubItemService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PayStubItem> findAll(Optional<Long> payStubId, Optional<String> applyYearMonth) {
        if (payStubId.isEmpty() || applyYearMonth.isEmpty())
            return Collections.emptyList();

        String query = "select cf.Name, cf.Title, pci.CompensationFactorPropertyRef, pci.ApplyYearMonth, pci.Value, cf.CompensationFactorID from HCM3.PayCalcItem pci join HCM3.CompensationFactor cf on cf.CompensationFactorID = pci.CompensationFactorRef where pci.PayCalcRef = ? and pci.ApplyYearMonth = ? order by cf.CompensationFactorID";
        return jdbcTemplate.query(query, new Object[]{payStubId.get(), applyYearMonth.get()}, new PayStubItemMapper());
    }
}
