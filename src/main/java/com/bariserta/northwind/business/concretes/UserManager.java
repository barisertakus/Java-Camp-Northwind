package com.bariserta.northwind.business.concretes;

import com.bariserta.northwind.business.abstracts.UserService;
import com.bariserta.northwind.core.dataAccess.UserDao;
import com.bariserta.northwind.core.entities.User;
import com.bariserta.northwind.core.utilites.results.DataResult;
import com.bariserta.northwind.core.utilites.results.Result;
import com.bariserta.northwind.core.utilites.results.SuccessDataResult;
import com.bariserta.northwind.core.utilites.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("User added.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(
                userDao.findByEmail(email),"User found"
        );
    }
}
