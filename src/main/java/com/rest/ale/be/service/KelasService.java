package com.rest.ale.be.service;

import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.KelasRepository;
import com.rest.ale.be.exception.ResourceTidakTersedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KelasService {
    @Autowired
    KelasRepository kelasRepo;

    public List<Kelas> getKelas() {
        return kelasRepo.findAll();
    }


    public Optional<Kelas> getAuthorById(Long id_kelas) {
        if (!kelasRepo.existsById(id_kelas)) {
            throw new ResourceTidakTersedia("Maaf, kelas dengan id " + id_kelas + " tidak ada");
        }
        return kelasRepo.findById(id_kelas);
    }


    public Kelas createAuthor(Kelas kelas) {
        return kelasRepo.save(kelas);

    }
//
//    public Author updateAuthorById(Long authorId, Author authorRequest) {
//        if (!authorDao.existsById(authorId)) {
//            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
//        }
//        Optional<Author> author = authorDao.findById(authorId);
//
//        if (!author.isPresent()) {
//            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
//        }
//
//        Author author1 = author.get();
//        author1.setFirstName(authorRequest.getFirstName());
//        author1.setLastName(authorRequest.getLastName());
//        return authorDao.save(author1);
//
//    }
//
//    public ResponseEntity<Object> deleteAuthorById(long authorId) {
//        if (!authorDao.existsById(authorId)) {
//            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
//        }
//
//        authorDao.deleteById(authorId);
//
//        return ResponseEntity.ok().build();
//
//    }
}
