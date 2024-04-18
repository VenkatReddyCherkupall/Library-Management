package com.sb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.beans.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

}
