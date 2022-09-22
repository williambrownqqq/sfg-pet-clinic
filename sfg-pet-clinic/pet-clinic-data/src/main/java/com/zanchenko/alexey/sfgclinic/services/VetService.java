package com.zanchenko.alexey.sfgclinic.services;

import com.zanchenko.alexey.sfgclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{
//    Vet findByID(Long id);
//    Vet save(Vet vet);
//    Set<Vet> findAll();
}
//  So now just to recap, our CrudService were mimicking the Spring Data
//  Repositories with our CrudService and this implements the methods that we
//  want to be implementing for our CrudService.
//  Итак, напомним, наш CrudService имитировал Spring Data.
//  Репозитории с нашим CrudService, и это реализует методы, которые мы хотите реализовать для
//  нашего CrudService.

//  Now all our services are going to implement our standard CrudService and add additional
//  methods where we need to. We can see that it cut down a bunch of codes so we
//  got rid of duplicate method codes in all three interfaces and those have been
//  pushed down to a common interface that we are going to inherit from, so a much
//  cleaner model here that we have moving forward
//  В настоящее время все наши сервисы будут реализовывать наш стандартный CrudService и
//  добавлять дополнительные методы там, где это необходимо.
//  Мы видим, что он сократил кучу кодов, поэтому мы избавились от повторяющихся кодов
//  методов во всех трех интерфейсах, и они были сдвинуты к общему интерфейсу,
//  от которого мы собираемся наследоваться, поэтому многое здесь более чистая модель,
//  которую мы продвигаем вперед