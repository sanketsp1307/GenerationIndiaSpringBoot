package com.example.redbank.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.redbank.Entity.Registeration;
import com.example.redbank.Repository.RegisterationRepository;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegisterationService {

    @Autowired
    private RegisterationRepository registrationRepository;

    @Transactional
    public List<Registeration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registeration addRegistration(Registeration registration) {
        return registrationRepository.save(registration);
    }

    public Registeration updateRegistration(int id, Registeration registration) {
        Registeration existingRegistration = registrationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                        "Registration with ID " + id + " not found."));
        registration.setUserId(existingRegistration.getUserId());
        return registrationRepository.save(registration);
    }

    public void deleteRegistrationById(int id) {
        registrationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                        "Registration with ID " + id + " not found."));
        registrationRepository.deleteById(id);
    }
}
