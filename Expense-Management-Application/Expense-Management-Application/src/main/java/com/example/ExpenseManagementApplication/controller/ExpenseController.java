package com.example.ExpenseManagementApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ExpenseManagementApplication.model.Expense;
import com.example.ExpenseManagementApplication.service.ExpenseService;

@RestController
@RequestMapping
public class ExpenseController {

	@Autowired
	 private ExpenseService expenseService;

	 @PostMapping("/expenses/save")
	 public Expense createExpense(@RequestBody Expense expense) {
	 return expenseService.saveExpense(expense);
	 }

	 @GetMapping("/expenses")
	 public List<Expense> getAllExpenses() {
	 return expenseService.getAllExpenses();
	 }

	 @PutMapping("/expenses/{id}")
	 public Expense updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
	 return expenseService.updateExpense(id, updatedExpense);
	 }

	 @DeleteMapping("/expenses/delete/{id}")
	 public void deleteExpense(@PathVariable Long id) {
	 expenseService.deleteExpense(id);
	 }
}
