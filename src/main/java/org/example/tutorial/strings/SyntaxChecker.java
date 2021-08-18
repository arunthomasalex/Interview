package org.example.tutorial.strings;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SyntaxChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases-- > 0) {
            String pattern = in.nextLine();
            Stack<String> brackets = new Stack<>();
            try {
                if(pattern.isEmpty()) throw new RuntimeException();
                Stream.of(pattern.split("")).forEach(c -> {
                    List<String> lst = null;
                    String ch = null;
                    switch(c) {
                        case ")":
                            lst = getLastBracket(brackets);
                            ch = lst.remove(lst.size() - 1);
                            if(lst.isEmpty() || !ch.equals("(")) throw new RuntimeException();
                            brackets.push("0");
                            break;
                        case "}": 
                            lst = getLastBracket(brackets);
                            ch = lst.remove(lst.size() - 1);
                            if(lst.isEmpty() || !ch.equals("{")) throw new RuntimeException();
                            brackets.push("0");
                            break;
                        case "]":
                            lst = getLastBracket(brackets);
                            ch = lst.remove(lst.size() - 1);
                            if(lst.isEmpty() || !ch.equals("[")) throw new RuntimeException();
                            brackets.push("0");
                            break;
                        default:
                            brackets.push(c);
                    }
                });
                if(brackets.isEmpty() || !brackets.stream().filter(c -> Pattern.matches("\\(|\\{|\\[", c)).findFirst().isPresent()) System.out.println("Valid");
                else System.out.println("Invalid");
            }
            catch(RuntimeException e) {
                System.out.println("Invalid");
            }
        }
        in.close();
    }

    private static List<String> getLastBracket(Stack<String> brackets) {
        List<String> lst = new ArrayList<>();
        String ch= null;
        while(!(ch = brackets.pop()).matches("\\{|\\[|\\(")) lst.add(ch);
        lst.add(ch);
        return lst;
    }
}
