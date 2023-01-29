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
// PetType is oe of these root entities inherits from baseEntity
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
