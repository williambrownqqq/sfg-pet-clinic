package com.zanchenko.alexey.sfgclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// This is specialties. It has one property called description, also inherits from base entity.
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity{
    @Column(name = "description")
    private String description;
}



