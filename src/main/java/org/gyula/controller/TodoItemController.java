package org.gyula.controller;

import lombok.extern.slf4j.Slf4j;
import org.gyula.model.TodoData;
import org.gyula.model.TodoItem;
import org.gyula.service.TodoItemService;
import org.gyula.util.AttributeNames;
import org.gyula.util.Mappings;
import org.gyula.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService service) {
        this.todoItemService = service;
    }

    // model attribute section

    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // handler methods

    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        log.info("editing item with id {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item: " + todoItemService.getItem(id).getTitle());
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
