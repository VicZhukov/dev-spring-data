package ua.goit.vic.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository notes;

    public Note add(Note note){
        return notes.save(note);
    }

    public Note getById(long id){
        return notes.findById(id)
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("Note with id " + id + " does not exist.");
                });
    }

    public void update(Note note){
        notes.findById(note.getId())
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("Note with id " + note.getId() + " does not exist.");
                });
        notes.save(note);
    }

    public void deleteById(long id){
        notes.findById(id)
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("Note with id " + id + " does not exist.");
                });
        notes.deleteById(id);
    }

    public List<Note> listAll(){
        return notes.findAll();
    }

    private long generateUniqueId(){
        return new Random().nextLong();
    }
}
