package com.example.ExpenseManagementApplication.repository.copy;



import org.springframework.data.repository.CrudRepository;

import com.example.ExpenseManagementApplication.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{

}
