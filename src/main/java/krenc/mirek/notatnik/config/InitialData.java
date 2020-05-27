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
        noteRepository.save(new Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in lorem nec leo sollicitudin luctus. Quisque dictum et turpis a volutpat. Praesent scelerisque nunc vitae nulla mollis, et sagittis nec.", LocalDate.now()));
        noteRepository.save(new Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in lorem nec leo sollicitudin luctus. Quisque dictum et turpis a volutpat. Praesent scelerisque nunc vitae nulla mollis, et sagittis nec.", LocalDate.now()));
    }
}
