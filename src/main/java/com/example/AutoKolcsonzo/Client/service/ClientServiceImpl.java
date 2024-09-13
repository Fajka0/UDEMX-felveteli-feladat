package com.example.AutoKolcsonzo.Client.service;

import com.example.AutoKolcsonzo.Client.Client;
import com.example.AutoKolcsonzo.Client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public Client saveClient( final Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

}
