package com.dch.model;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dch.model.strategies.Added;
import com.dch.model.strategies.CalculateStrategies;
import com.dch.model.strategies.Divided;
import com.dch.model.strategies.Minused;
import com.dch.model.strategies.Multiplyed;



public class ExpressionParser {
    private static final Map<String, CalculateStrategies> strategies = new HashMap<>();

    static {
        strategies.put("+", new Added());
        strategies.put("-", new Minused());
        strategies.put("*", new Multiplyed());
        strategies.put("/", new Divided());
    }
    
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("(\\d+)\\s*([+\\-*/])\\s*(\\d+)");
    
    public double parseAndCalculate(String expresion) {
        Matcher mather = EXPRESSION_PATTERN.matcher(expresion);

        if (mather.matches()) {
            int num1 = Integer.parseInt(mather.group(1));
            String operator = mather.group(2);
            int num2 = Integer.parseInt(mather.group(3));


            CalculateStrategies strategy = strategies.get(operator);

            if (strategy != null) {
                return strategy.execute(num1, num2);

            } else {
                throw new IllegalArgumentException("Unsupported operator: " + operator);
            }

        } else {
            throw new IllegalArgumentException("Invalid expression format");

        }
    }w
}
