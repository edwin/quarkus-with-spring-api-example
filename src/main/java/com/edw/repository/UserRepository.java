package com.edw.repository;

import com.edw.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *     com.edw.repository.UserRepository
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 16 Des 2019 12:25
 */
public interface UserRepository extends JpaRepository<User, String> {
}
