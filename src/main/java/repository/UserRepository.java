package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ольга on 06.08.2014.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
