package org.gyula.service;

import lombok.Getter;
import org.gyula.model.TodoData;
import org.gyula.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Getter
    public final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem item) {
        data.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem item) {
        data.updateItem(item);
    }


}
