package service.impl;

import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdminRepository;
import service.AdminService;

/**
 * Created by Ольга on 06.08.2014.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin findAdminByLogin(String login) {return adminRepository.findByLogin(login); }
}
