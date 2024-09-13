package com.example.AutoKolcsonzo.Client.service;

import com.example.AutoKolcsonzo.Client.Client;

import java.util.List;

public interface ClientService {

    Client saveClient(Client client);

    List<Client> findAll();
}
