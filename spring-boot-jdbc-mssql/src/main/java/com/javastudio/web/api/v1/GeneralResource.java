package com.javastudio.web.api.v1;

import com.javastudio.mapper.StreamingJsonResultSetExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping("/api/v1/general")
public class GeneralResource {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<StreamingResponseBody> query() {
        StreamingResponseBody stream = out -> {
            jdbcTemplate.query("select * from product", new StreamingJsonResultSetExtractor(out));
        };
        return ResponseEntity.ok(stream);
    }
}


