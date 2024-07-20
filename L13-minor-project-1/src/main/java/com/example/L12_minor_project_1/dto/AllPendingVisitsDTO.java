package com.example.L12_minor_project_1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AllPendingVisitsDTO {

    private List<VisitDto> visits;

    private Long totalRows;

    private Integer totalPages;
}
