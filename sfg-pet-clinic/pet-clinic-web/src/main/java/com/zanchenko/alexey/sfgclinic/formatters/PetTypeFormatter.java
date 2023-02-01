package com.zanchenko.alexey.sfgclinic.formatters;

import com.zanchenko.alexey.sfgclinic.model.PetType;
import com.zanchenko.alexey.sfgclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}

// In the implementation again, we're going to go into the pet service to findAll and then
//basically match on name. Again the default behavior was trying to generate
//a PetType and using the String and putting it into the ID property so the
//automatic parsing magic of Spring was failing us there and it was because I
//was missing this formatter component.