package com.easy_notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easy_notes.model.Note;

@Repository// tells Spring to bootstrap the repository during component scan.
public interface NoteRepository extends JpaRepository<Note, Long> {

}
