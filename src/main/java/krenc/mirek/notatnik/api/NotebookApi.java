package krenc.mirek.notatnik.api;

import krenc.mirek.notatnik.exception.NoteNotFoundException;
import krenc.mirek.notatnik.model.Note;
import krenc.mirek.notatnik.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NotebookApi {

    private NoteRepository noteRepository;
    private Logger logger = LoggerFactory.getLogger(NotebookApi.class);

    public NotebookApi(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping
    public ResponseEntity getAllNotes() {
        List<Note> noteList = noteRepository.findAll();
        return noteList != null ? new ResponseEntity(noteRepository.findAll(), HttpStatus.OK) : new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneNote(@PathVariable Long id)
    {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent())
            return new ResponseEntity(optionalNote.get(), HttpStatus.OK);
        else
            throw new NoteNotFoundException("Note with id = " + id + " not found");
    }

    @PostMapping
    public ResponseEntity addNote(@RequestBody Note note)
    {
        Note noteSaved = noteRepository.save(note);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(noteSaved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> editNote(@PathVariable long id, @RequestBody Note note)
    {
        Optional<Note> noteOptional = noteRepository.findById(id);
        Note noteEdit = null;
        if (noteOptional.isPresent()) {
            noteEdit = noteOptional.get();
            if (note.getContent() != null)
            noteEdit.setContent(note.getContent());
            if (note.getCreated() != null)
            noteEdit.setCreated(note.getCreated());

            noteRepository.save(noteEdit);
            return new ResponseEntity(noteEdit, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deletetNote(@PathVariable long id)
    {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            noteRepository.delete(noteOptional.get());
            return new ResponseEntity(noteOptional.get(), HttpStatus.OK);
        }
        else
            return ResponseEntity.noContent().build();
    }


}
