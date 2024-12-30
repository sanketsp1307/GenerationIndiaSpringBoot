package com.example.redbank.Controller;

import com.example.redbank.Entity.Registeration;
import com.example.redbank.Service.RegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/registeration")
public class RegistrationController {

    @Autowired
    private RegisterationService registrationService;

    @GetMapping("/get")
    public ResponseEntity<List<Registeration>> getAllRegistrations() {
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }

    @PostMapping("/add")
    public ResponseEntity<Registeration> addRegistration(@RequestBody Registeration registration) {
        Registeration savedRegistration = registrationService.addRegistration(registration);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegistration);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRegistration(@RequestParam int id, @RequestBody Registeration registration) {
        try {
            return ResponseEntity.ok(registrationService.updateRegistration(id, registration));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registration not found for ID: " + id);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRegistration(@RequestParam int id) {
        registrationService.deleteRegistrationById(id);
        return ResponseEntity.noContent().build();
        
    }
}
