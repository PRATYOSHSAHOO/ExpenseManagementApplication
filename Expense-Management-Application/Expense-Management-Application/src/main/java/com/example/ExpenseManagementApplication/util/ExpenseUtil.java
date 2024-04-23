package com.example.ExpenseManagementApplication.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.ExpenseManagementApplication.model.Expense;

@Component
public class ExpenseUtil {
	public void validateExpense(Expense expense) {
		if (StringUtils.isEmpty(expense.getId())) {
			throw new IllegalArgumentException("Id cannot be empty");
		}
		if (StringUtils.isEmpty(expense.getDate())) {
			throw new IllegalArgumentException("Date cannot be empty");
		}
		if (StringUtils.isEmpty(expense.getAmount())) {
			throw new IllegalArgumentException("Expense amount cannot be empty");
		}

		if (StringUtils.isEmpty(expense.getCategory())) {
			throw new IllegalArgumentException("Expense category cannot be empty");
		}

		if (StringUtils.isEmpty(expense.getDescription())) {
			throw new IllegalArgumentException("Expense description cannot be empty");
		}
	}
}
