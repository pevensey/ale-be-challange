package com.rest.ale.be.repository;

import com.rest.ale.be.model.DBFile;
import com.rest.ale.be.model.GetFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile,String> {

    @Query("SELECT new com.rest.ale.be.model.GetFile (v.id, v.fileName, v.fileType) FROM DBFile v")
    List<GetFile> ambilFile();
}
