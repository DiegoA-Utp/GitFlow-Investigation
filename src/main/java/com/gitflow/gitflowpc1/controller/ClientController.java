package com.gitflow.gitflowpc1.controller;

import com.gitflow.gitflowpc1.entity.Client;
import com.gitflow.gitflowpc1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }


    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,@RequestBody Client client){
        return ResponseEntity.ok(clientService.updateClient(id,client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
