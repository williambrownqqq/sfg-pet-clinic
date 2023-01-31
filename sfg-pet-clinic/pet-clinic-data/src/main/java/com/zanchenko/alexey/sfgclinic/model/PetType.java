package com.zanchenko.alexey.sfgclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
// PetType is oe of these root entities inherits from baseEntity
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    @Builder
    public PetType(Long id, String name){
        super(id);
        this.name = name;
    }
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}

// So before I do that, found one thing PetType. I implemented the Builder pattern so I didn't have this
//constructor here.
//I wasn't able to use the id property so now I created a constructor for the id and name so and this
//is Project Lombok so I remove the Builder from the class level annotation and put it on the constructor
//and set up a constructor because we're extending out that BaseEntity.
//And I want to build use the Builder pattern with this as well so I was a little refactoring and I am
//going to commit this
//I'm just showing you a way of doing small incremental commits.

// Итак, прежде чем я это сделаю, обнаружил одну вещь PetType. Я реализовал паттерн Builder, поэтому у меня не было этого
//конструктора здесь.
//Я не мог использовать свойство id, так что теперь я создал конструктор для id и имени, так что и это
//это Project Lombok, поэтому я удаляю Builder из аннотации на уровне класса и помещаю его в конструктор.
//и создаю конструктор, потому что мы расширяем BaseEntity.
//И я хочу использовать паттерн Builder и с этим, поэтому я немного рефакторингом и я
//собираюсь зафиксировать это
//Я просто показываю вам способ делать небольшие инкрементные фиксации.