package hello.repositories;

import org.springframework.data.repository.CrudRepository;
import hello.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// Could extend JpaRepository provides some goodies like
// paging and sorting which most of the time is needed in a FE application
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}
