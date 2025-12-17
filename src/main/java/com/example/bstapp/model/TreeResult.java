package com.example.bstapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TreeResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String inputNumbers;

    @Lob
    private String treeJson;

    private LocalDateTime createdAt;

    public TreeResult() {}

    public TreeResult(String inputNumbers, String treeJson, LocalDateTime createdAt) {
        this.inputNumbers = inputNumbers;
        this.treeJson = treeJson;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getInputNumbers() { return inputNumbers; }
    public String getTreeJson() { return treeJson; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
