package krenc.mirek.notatnik.repository;

import krenc.mirek.notatnik.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
