package repository;

import model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    @Transactional
    @Query("select admin from Admin admin where admin.login = ?1")

    Admin findByLogin(String login);
}
