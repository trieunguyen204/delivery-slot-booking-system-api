package com.deliveryslotbookingapi.slot;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "slot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deliveryDate", nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "startTime",nullable = false)
    private LocalTime startTime;

    @Column(name = "endTime",nullable = false)
    private LocalTime endTime;

    @Column(name = "capacity",nullable = false)
    private Long capacity;

    @Column(name="booked_count",nullable = false)
    private Long bookedCount=0L;

    @Enumerated(EnumType.STRING) // neu khong co : jpa chi luu thu tu enum 0 1 2 ...
    @Column(name = "Status",nullable = false)
    private  Status status;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt=LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedAt=LocalDateTime.now();
    }
    @Transient
    public Long getAvailableCapacity(){
        return capacity-bookedCount;
    }
}
