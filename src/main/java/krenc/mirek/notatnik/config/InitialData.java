package krenc.mirek.notatnik.config;

import krenc.mirek.notatnik.model.Note;
import krenc.mirek.notatnik.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;

@Configuration
public class InitialData implements CommandLineRunner {

    private NoteRepository noteRepository;

    public InitialData(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        noteRepository.save(new Note("Pierwsza notatka", LocalDate.now()));
        noteRepository.save(new Note("Druga notatka", LocalDate.now()));
    }
}
