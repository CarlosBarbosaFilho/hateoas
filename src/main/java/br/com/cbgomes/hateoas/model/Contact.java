package br.com.cbgomes.hateoas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
public class Contact extends RepresentationModel<Contact> {

    private final String name;
    private final String email;
    private final String phone;

    @JsonCreator
    public Contact(@JsonProperty ( "name" ) String name,
                   @JsonProperty ( "email" ) String email,
                   @JsonProperty ( "phone" ) String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
