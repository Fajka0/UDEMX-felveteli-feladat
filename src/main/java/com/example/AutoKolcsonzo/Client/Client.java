package com.example.AutoKolcsonzo.Client;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cllients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public Client(final String name,final String email, final String address, final String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
