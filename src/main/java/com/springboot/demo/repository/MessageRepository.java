package com.springboot.demo.repository;

import com.springboot.demo.domain.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author https://github.com/SproutMJ
 * @exception
 * @param
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
