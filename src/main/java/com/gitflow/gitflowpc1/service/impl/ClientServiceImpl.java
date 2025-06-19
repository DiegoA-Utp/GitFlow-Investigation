package com.gitflow.gitflowpc1.service.impl;

import com.gitflow.gitflowpc1.dao.ClientDao;
import com.gitflow.gitflowpc1.entity.Client;
import com.gitflow.gitflowpc1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    @Transactional
    @Override
    public Client createClient(Client client) {
        return clientDao.save(client);
    }

    @Transactional
    @Override
    public Client updateClient(Long id, Client client) {
        Client oldClient = clientDao.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        oldClient.setName(client.getName());
        oldClient.setDni(client.getDni());
        oldClient.setApellido(client.getApellido());
        oldClient.setDireccion(client.getDireccion());
        oldClient.setFechaNacimiento(client.getFechaNacimiento());
        return clientDao.save(oldClient);
    }

    @Transactional
    @Override
    public void deleteClient(Long id) {
        clientDao.deleteById(id);
    }
}
