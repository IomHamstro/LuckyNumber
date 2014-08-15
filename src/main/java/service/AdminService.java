package service;

import model.Admin;

/**
 * Created by Ольга on 06.08.2014.
 */

public interface AdminService {
    Admin findAdminByLogin(String login);
}
