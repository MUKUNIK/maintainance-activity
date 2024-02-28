package com.nikhil.maintainanceactivity.repo;

import com.nikhil.maintainanceactivity.model.*;
import org.springframework.data.mongodb.repository.*;

public interface UserRepository extends MongoRepository<User,Integer> {
    User findByName(String name);
}
