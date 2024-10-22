package uz.blacknet.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.blacknet.thymeleaf.entity.Photo;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long>
{

    Optional<Photo> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM photo WHERE id= :id", nativeQuery = true)
    void delete(Long id);

    Optional<Photo> findByUrl(String url);

    @Modifying
    @Query(value = "UPDATE photo SET url= :url WHERE id= :id", nativeQuery = true)
    void setUrl(String url, Long id);
}
