package com.example.L12_minor_project_1.entity;


import com.example.L12_minor_project_1.enums.VisitStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    @Column(nullable = false)
    private String purpose;

    private Date inTime;

    private Date outTime;

    private String imageUrl;

    @Column(nullable = false)
    private Integer noOfPeople;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updateDate;

}
