package epicode.u5s2g4.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.u5s2g4.entities.User;
import epicode.u5s2g4.entities.payloads.UserRegistrationPayload;
import epicode.u5s2g4.exceptions.BadRequestException;
import epicode.u5s2g4.exceptions.NotFoundException;
import epicode.u5s2g4.repositories.UsersRepository;

@Service
public class UsersService {
	@Autowired
	UsersRepository usersRepo;

	public User findById(UUID id) throws NotFoundException {
		return usersRepo.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato!"));

	}

	public User create(UserRegistrationPayload u) {

		usersRepo.findByEmail(u.getEmail()).ifPresent(user -> {
			throw new BadRequestException("Email " + user.getEmail() + " already in use!");
		});
		User newUser = new User(u.getUsername(), u.getNome(), u.getEmail(), u.getPassword());
		return usersRepo.save(newUser);
	}

	public User findByEmail(String email) throws NotFoundException {
		return usersRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Utente con questa mail: " + email + " non trovato!"));
	}
}
