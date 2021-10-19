package org.gyula.service;

import org.gyula.model.TodoData;
import org.gyula.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem item);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem item);

    TodoData getData();
}
