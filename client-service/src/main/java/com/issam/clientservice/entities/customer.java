package com.issam.clientservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String firstName;

    private String lastName;
    private String email;
}
