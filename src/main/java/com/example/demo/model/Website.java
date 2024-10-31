package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passwords")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Website {
    @Id
    @GeneratedValue
    Long id;
    String websiteName;
    @Column(unique = true)
    String link;
    String password;
}
