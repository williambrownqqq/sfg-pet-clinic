package com.zanchenko.alexey.sfgclinic.bootstrap;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import com.zanchenko.alexey.sfgclinic.model.Vet;
import com.zanchenko.alexey.sfgclinic.services.OwnerService;
import com.zanchenko.alexey.sfgclinic.services.VetService;
import com.zanchenko.alexey.sfgclinic.services.map.OwnerServiceMap;
import com.zanchenko.alexey.sfgclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.image.SampleModel;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("ALex");
        owner2.setLastName("Zanchenko");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bob");
        vet2.setLastName("Axe");

        vetService.save(vet2);
        System.out.println("Loaded Vets...");

    }
}
