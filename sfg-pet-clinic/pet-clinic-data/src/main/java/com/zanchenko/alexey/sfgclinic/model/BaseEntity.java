package com.zanchenko.alexey.sfgclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//Base Entity that things inherit from
@Getter // we can get rid of getters in class
@Setter // we can get rid of setters in class
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass // this established this ass a base class to JPA. // What we are
//doing is saying, "Hey JPA, we're going to inherit from this class or other classes
//        are going to be inheriting it. We don't need this specific class mapped to the
//database" // Нам не нужно, чтобы этот конкретный класс отображался на база данных
public class BaseEntity implements Serializable {
    @Id // This annotation tells JPA that this is the ID value.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Now IDENTITY, which is what we've selected is saying that we're
    //going to insert it in the database is going to provide us the identity value.
    // Теперь ИДЕНТИЧНОСТЬ, которую мы выбрали, говорит, что мы собирается вставить его в базу данных, чтобы предоставить нам значение идентификатора.
    private Long id;
}



// GenerationType
//AUTO can give you some problems as far
//as unpredictable results. IDENTITY does tie you to the specific database.
//SEQUENCE is a good choice.
// AUTO может доставить вам некоторые проблемы как непредсказуемые результаты. IDENTITY привязывает вас к конкретной базе данных. ПОСЛЕДОВАТЕЛЬНОСТЬ - хороший выбор.


// TABLE means that we're going to have a database table with the sequence number
//on that, so we'll have a value on a database table that we're going to use to
//determine the maximum value and then the next value. A SEQUENCE, databases have
//what's called a sequence generator, where you can say give me the next number in a
//sequence. The functionality there and this is depends on the underlying
//database. Now IDENTITY, which is what we've selected is saying that we're
//going to insert it in the database is going to provide us the identity value.

// TABLE означает, что у нас будет таблица базы данных с порядковым номером на этом, поэтому у нас будет значение в
// таблице базы данных, которое мы собираемся использовать для определить максимальное значение, а затем следующее значение.
// ПОСЛЕДОВАТЕЛЬНОСТЬ, базы данных то, что называется генератором последовательности, где вы можете сказать мне следующее число
// в последовательность. Функциональность там, и это зависит от основного база данных.
// Теперь ИДЕНТИЧНОСТЬ, которую мы выбрали, говорит, что мы собирается вставить его в базу данных, чтобы предоставить нам значение идентификатора.
// AUTO is basically saying that we're
//gonna pick one and we're going to allow Hibernate to look at the underlying
//database and determine a strategy to use.
// AUTO в основном говорит, что мы собираемся выбрать один, и мы позволим Hibernate взглянуть на основной базы данных
// и определить стратегию для использования.

// We have a @MappedSuperclass. That
//indicates that this object is not to be created in the database that we
//are expecting other classes to inherit from it.

// the @column annotation. This sets up the the naming
//convention for the database column, so this says, this is what we're going to
//expect the database columns to be.