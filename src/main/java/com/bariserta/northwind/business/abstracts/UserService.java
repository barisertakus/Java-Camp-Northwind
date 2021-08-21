package com.bariserta.northwind.business.abstracts;

import com.bariserta.northwind.core.entities.User;
import com.bariserta.northwind.core.utilites.results.DataResult;
import com.bariserta.northwind.core.utilites.results.Result;

public interface UserService {
    Result add(User user);

    DataResult<User> findByEmail(String email);
}
