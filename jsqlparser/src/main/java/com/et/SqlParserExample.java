package com.et;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.expression.Expression;

import java.util.List;

public class SqlParserExample {
    public static void main(String[] args) {
        // SQL query to be parsed
        String sql = "SELECT id, name FROM users WHERE age > 30";
        try {
            // Parse the SQL statement
            Statement statement = CCJSqlParserUtil.parse(sql);
            
            // Ensure the parsed statement is a SELECT statement
            if (statement instanceof Select) {
                Select selectStatement = (Select) statement;
                PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();

                // Get the selected columns
                List<SelectItem> selectItems = plainSelect.getSelectItems();
                System.out.println("Selected columns:");
                for (SelectItem item : selectItems) {
                    System.out.println(item);
                }

                // Get the WHERE condition
                Expression where = plainSelect.getWhere();
                System.out.println("WHERE condition:");
                if (where != null) {
                    System.out.println(where);
                } else {
                    System.out.println("No WHERE condition");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an exception
        }
    }
}