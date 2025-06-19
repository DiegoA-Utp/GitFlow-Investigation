package com.gitflow.gitflowpc1.service;


import com.gitflow.gitflowpc1.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client createClient(Client client);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}
