package com.example.demo.todo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    private final TodoRepository repository;

    public TodoService(TodoRepository repository){
        this.repository = repository;
    }

    //登録処理
    public TodoEntity create(String title, boolean done){
        TodoEntity entity = new TodoEntity(title, done);
        return repository.save(entity);
    }

    //全件取得
    public List<TodoEntity> getAll(){
        return repository.findAll();
    }

    //更新処理
    public TodoEntity update(Long id, String title, boolean done){
        TodoEntity entity = repository.findById(id).orElseThrow();
        entity.setTitle(title);
        entity.setDone(done);
        return repository.save(entity);
    }

    //削除処理
    public void delete(Long id){
        repository.deleteById(id);
    }
    
}
