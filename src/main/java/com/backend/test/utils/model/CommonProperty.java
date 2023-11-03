package com.backend.test.utils.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.sql.Timestamp;

@Data
@MappedSuperclass
public class CommonProperty {
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_by_name")
    private String createdByName;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_by_name")
    private String updatedByName;


}
