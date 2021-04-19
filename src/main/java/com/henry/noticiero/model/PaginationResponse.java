package com.henry.noticiero.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse <H> implements Serializable {

private List<H> response;
private int totalPages;
private Long totalElements;

    public PaginationResponse(List<H> noticiasList, int i, long size) {
    }
}
