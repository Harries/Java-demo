package com.et;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.statement.select.SelectExpressionItem; // Ensure SelectExpressionItem class is imported

import java.util.ArrayList;
import java.util.List;

public class SqlGeneratorExample {
    public static void main(String[] args) {
        // Create a Select object
        Select select = new Select();
        
        // Create a PlainSelect object
        PlainSelect plainSelect = new PlainSelect();
        
        // Set the selected columns
        List<SelectItem> selectItems = new ArrayList<>();
        selectItems.add(new SelectExpressionItem(new Column("id"))); // Use Column class for "id"
        selectItems.add(new SelectExpressionItem(new Column("name"))); // Use Column class for "name"
        plainSelect.setSelectItems(selectItems);
        
        // Set the table
        Table table = new Table("users");
        plainSelect.setFromItem(table);
        
        // Set the WHERE condition
        BinaryExpression whereCondition = new GreaterThan(); // Create a GreaterThan expression
        whereCondition.setLeftExpression(new Column("id")); // Set the left expression to the "id" column
        whereCondition.setRightExpression(new LongValue(10)); // Set the right expression to a LongValue of 10
        plainSelect.setWhere(whereCondition);
        
        // Set the PlainSelect as the SelectBody
        select.setSelectBody(plainSelect);
        
        // Generate the SQL statement
        String generatedSql = select.toString();
        System.out.println(generatedSql); // Print the generated SQL statement
    }
}