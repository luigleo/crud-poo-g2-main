package g2.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import g2.entities.GenericEntity;
import g2.repositories.GenericRepository;

public interface GenericService<TEntidade extends GenericEntity> {

    GenericRepository<TEntidade> getRepository();

    default void validarSave(TEntidade objeto) throws Exception {
    }

    default TEntidade save(TEntidade objeto) throws Exception {
        validarSave(objeto);
        return getRepository().save(objeto);
    }

    default Optional<TEntidade> findById(long id) throws Exception {
        if (!getRepository().existsById(id))
            throw new Exception("Não existe registro com este Id");
        return getRepository().findById(id);
    }

    default void deleteById(long id) {
        getRepository().deleteById(id);
        ;
    }

    default Page<TEntidade> findByNome(Pageable pageable, String nome) {
        return getRepository().findByNomeContainingIgnoreCase(pageable, nome);
    }

    default Page<TEntidade> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

}