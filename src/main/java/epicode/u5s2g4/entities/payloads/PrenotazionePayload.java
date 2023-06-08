package epicode.u5s2g4.entities.payloads;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PrenotazionePayload {
	@NotNull(message = "L' utente è obbligatorio")
	UUID userId;
	@NotNull(message = "La postazione è obbligatoria")
	UUID postazioneId;
	@NotNull(message = "La data è obbligatoria")
	LocalDate dataPrenotata;

}
