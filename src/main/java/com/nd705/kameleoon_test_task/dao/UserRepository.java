package com.nd705.kameleoon_test_task.dao;

import com.nd705.kameleoon_test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
