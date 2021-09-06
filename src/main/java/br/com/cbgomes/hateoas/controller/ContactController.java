package br.com.cbgomes.hateoas.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import br.com.cbgomes.hateoas.model.Contact;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/hateoas")
public class ContactController {

    @PostMapping
    public HttpEntity<Contact> contactWelcome(@RequestBody Contact contact){
            Contact.builder()
                    .name(String.format("Welcome", contact.getName()))
                    .email(String.format("your email is",contact.getEmail()))
                    .phone(String.format("and phone is",contact.getPhone()))
                    .build();
        contact.add(linkTo(methodOn(ContactController.class)
                .contactWelcome(contact))
                .slash(contact.getEmail())
                .withSelfRel()
                .withType("GET"));

        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}
