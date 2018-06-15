package ro.hobbinterest.repository;

import java.util.Optional;

public interface CustomCrudRepository<T,S> {

    Optional<T> findByIdD(S id);

}
