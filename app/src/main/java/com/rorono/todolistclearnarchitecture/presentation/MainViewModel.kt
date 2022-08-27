package com.rorono.todolistclearnarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rorono.todolistclearnarchitecture.data.TodoRepositoryImpl
import com.rorono.todolistclearnarchitecture.domain.DeleteTodoItemUseCase
import com.rorono.todolistclearnarchitecture.domain.EditTodoItemUseCase
import com.rorono.todolistclearnarchitecture.domain.GetTodoListUseCase
import com.rorono.todolistclearnarchitecture.domain.TodoItem

class MainViewModel : ViewModel() {

    private val repository = TodoRepositoryImpl

    private val getTodoListUseCase = GetTodoListUseCase(repository)
    private val deleteTodoItemUseCase = DeleteTodoItemUseCase(repository)
    private val editTodoItemUseCase = EditTodoItemUseCase(repository)

    val todoList = getTodoListUseCase.getTodoList()

    fun deleteTodoList(todoItem: TodoItem) {
        deleteTodoItemUseCase.deleteTodoItem(todoItem = todoItem)

    }
    fun changeEnableState(todoItem: TodoItem) {
        val newItem = todoItem.copy(taskCompleted = !todoItem.taskCompleted)
        editTodoItemUseCase.editTodoItem(newItem)

    }

}