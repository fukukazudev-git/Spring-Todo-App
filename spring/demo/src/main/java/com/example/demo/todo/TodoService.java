package com.example.demo.todo;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.TodoEntity;
import com.example.demo.todo.repository.TodoRepository;

@Service
public class TodoService {
    
    private final TodoRepository repository;

    public TodoService(TodoRepository repository){
        this.repository = repository;
    }

    //登録処理
    public TodoDto create(TodoDto dto){
        TodoEntity entity = new TodoEntity(dto.getTitle(), dto.isDone());
        TodoEntity saved = repository.save(entity);
        return new TodoDto(saved.getId(), saved.getTitle(), saved.isDone());
    }

    //全件取得
    public List<TodoDto> getAll(){
        return repository.findAll().stream()
                .map(e -> new TodoDto(e.getId(), e.getTitle(), e.isDone()))
                .toList();
    }

    //更新処理
    public TodoDto update(Long id, TodoDto dto){
        TodoEntity entity = repository.findById(id).orElseThrow();
        entity.setTitle(dto.getTitle());
        entity.setDone(dto.isDone());
        TodoEntity updated = repository.save(entity);
        return new TodoDto(updated.getId(), updated.getTitle(), updated.isDone());
    }

    //削除処理
    public void delete(Long id){
        repository.deleteById(id);
    }
    
}
