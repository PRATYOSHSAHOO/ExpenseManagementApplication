package com.example.ExpenseManagementApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExpenseManagementApplication.model.Expense;
import com.example.ExpenseManagementApplication.repository.copy.ExpenseRepository;
import com.example.ExpenseManagementApplication.util.ExpenseUtil;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private ExpenseUtil expenseUtil;

	public Expense saveExpense(Expense expense) {
		expenseUtil.validateExpense(expense);
		return expenseRepository.save(expense);
	}

	public List<Expense> getAllExpenses() {
		return (List<Expense>) expenseRepository.findAll();
	}

	public Expense updateExpense(Long id, Expense updatedExpense) {
		expenseUtil.validateExpense(updatedExpense);
		Expense expense = expenseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Expense not found with ID: " + id));

		expense.setAmount(updatedExpense.getAmount());
		expense.setCategory(updatedExpense.getCategory());
		expense.setDescription(updatedExpense.getDescription());

		return expenseRepository.save(expense);
	}

	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
