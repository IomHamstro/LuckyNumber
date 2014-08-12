package repository;

import model.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ольга on 06.08.2014.
 */
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
