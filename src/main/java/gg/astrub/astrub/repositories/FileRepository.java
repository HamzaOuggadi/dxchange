package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
