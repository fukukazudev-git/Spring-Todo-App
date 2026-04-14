package com.example.demo.todo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.todo.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    
}
/*memo
save() → INSERT/UPDATE
findAll() → SELECT
deleteById() → DELETE
Spring Data JPA がすべて自動で実装してくれるため、
開発者はインターフェースを定義するだけで基本的なCRUD操作が利用可能になる。
 */