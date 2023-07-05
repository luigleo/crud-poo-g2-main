package g2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import g2.entities.GenericEntity;

@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericEntity>
        extends JpaRepository<TEntidade, Long> {

    Page<TEntidade> findByNomeContainingIgnoreCase(Pageable pageable, String nome);

    boolean existsByNomeAndIdNot(String nome, long id);
}