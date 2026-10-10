package com.example.demo.aitools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTool {

    @Tool(description = """
    Performs arithmetic calculations.
    Supported operations: add, subtract, multiply, divide, mod, power.
    """)
    public double calculate(
            @ToolParam(description = "Arithmetic operation to perform: add, subtract, multiply, divide, mod, or power")
            String operation,
            @ToolParam(description = "First Number")
            double a,
            @ToolParam(description = "Second Number")
            double b){

        System.out.println("Calculator Tool Called");

        if(operation.equals("add")){
            return a + b;
        }else if (operation.equals("sub")){
            return a - b;
        }else if (operation.equals("mul")) {
            return a * b;
        }else if (operation.equals("divide")){
            if(b == 0){
                throw new ArithmeticException("Cannot divide by 0");
            }
            return a / b;
        }else if (operation.equals("mod")){
            if(b == 0){
                throw new ArithmeticException("Cannot calc mod by 0");
            }
            return a / b;
        }else if (operation.equals("power")){
            return Math.pow(a, b);
        }else {
            throw new IllegalArgumentException("Unsupported operation : " + operation);
        }
    }
}
