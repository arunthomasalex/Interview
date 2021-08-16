package org.example.tutorial.puzzle;

import java.util.*;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;
/*
Input
-----
{}()
({()})
{}(
[]

Output
------
true
true
false
true
*/
public class BracketValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while (sc.hasNext()) {
			String input=sc.next();
            inputs.add(input);            
		}
        inputs.forEach(input -> {
            try {
                Stack<String> s = new Stack<>();
                if(input.length() % 2 != 0) throw new RuntimeErrorException(null, "");
                Stream.of(input.split("")).forEach(b -> {
                    if(b.equals("{") || b.equals("(") || b.equals("[")) {
                        s.push(b);
                    } else {
                        switch(b) {
                            case "}":
                                if(!s.pop().equals("{"))
                                    throw new RuntimeErrorException(null, "");
                                break;
                            case ")":
                                if(!s.pop().equals("("))
                                    throw new RuntimeErrorException(null, "");
                                break;
                            case "]":
                                if(!s.pop().equals("["))
                                    throw new RuntimeErrorException(null, "");
                                break;
                            default:
                                throw new RuntimeErrorException(null, "");
                        }
                    }
                });
                System.out.println("true");
            }catch(RuntimeException e) {
                System.out.println("false");
            }
        });
        sc.close();
    }
}
