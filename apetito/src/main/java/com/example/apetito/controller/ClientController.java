package com.example.apetito.controller;

import com.example.apetito.model.Client;
import com.example.apetito.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    /*
    @PostMapping("/add")
    public ResponseEntity<?> registerClient(@RequestBody Client client) {
        Optional<Client> existingClient = clientService.findClientByEmail(client.getEmail());
        if (existingClient.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ten adres e-mail jest już używany.");
        }
        // Zakodowanie hasła jest już obsługiwane w ClientService#addClient
        Client newClient = clientService.addClient(client);
        // Odpowiedź może zwracać tylko bezpieczne informacje o nowo utworzonym kliencie
        return ResponseEntity.ok().body("Klient został pomyślnie zarejestrowany.");
    }

     */
}
