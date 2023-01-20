package com.zanchenko.alexey.sfgclinic.controllers;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import com.zanchenko.alexey.sfgclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class) // we are extending it out with MockitoExtension which will initialize the mocks for us.
class OwnerControllerTest {

    @Mock
    OwnerService ownerService; // we only have one mock here
    @InjectMocks // commands in mockito to init mocks that you run in the setUp method and @ExtendWith effectively does the same thing for us
    OwnerController controller; // we are using the Mockito @InjectMocks which will set up the controller with the mocks injected int it, and then in our setUp method

    Set<Owner> owners;

    MockMvc mockMvc;
    @BeforeEach // setting up this way in case i have more than one test.
    // this does give me an object that gets it reinitialize that i can use for additional tests if i wanna test out different scenarios.
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        // initialize Spring MVC
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build(); // set up an environment for Spring Controller to run in. It's all Mock environment. It doesn't actually pull up a server which is really quite nice
    } // we are initializing an owners object which we'll use for the return value the controllers.

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners"))
                //.andExpect(status().is(200));
                .andExpect(status().isOk()) // expecting a status of ok which is an HTTP status of 200
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2))); // our mock returning bck a Set that has two elements on it.
        // so i'm gonna make sure that i have an attribute called owners which has a size of 2 and the view name of owners/index returns
    }

    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/index"))
                //.andExpect(status().is(200));
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2))); // our mock returning bck a Set that has two elements on it.
        // so i'm gonna make sure that i have an attribute called owners which has a size of 2 and the view name of owners/index returns
    }

    @Test
    void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyNoInteractions(ownerService);
    }
}