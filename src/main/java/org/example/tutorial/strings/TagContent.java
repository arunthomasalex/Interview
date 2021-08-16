package org.example.tutorial.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Input
-----
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

Output
------
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush
*/
public class TagContent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<String> lines = new ArrayList<>();
        while (testCases > 0) {
            String line = in.nextLine();

            String leftTag = null, rightTag = null, subString = line;
            Pattern pattern = Pattern.compile("<([\\w {}`'=~@$#&%_!,\"\\^\\.\\*\\-\\+\\(\\)]+?)>");
            Matcher matcher = null;
            int removeIndex = -1;
            boolean selected = false, enter = true;
            List<String> subLines = new ArrayList<>();
            while(true) {
                matcher = pattern.matcher(subString);
                if(!matcher.find()) {
                    if(selected) {
                        if(enter && !subString.isEmpty() && !subLines.contains(subString))
                            subLines.add(subString);
                        subString = line = line.substring(removeIndex);
                        selected = false;
                        removeIndex = -1;
                        continue;
                    }
                    break;
                } 
                leftTag = matcher.group();
                rightTag = "</" + matcher.group(1) + ">";
                int lastOccurence = subString.lastIndexOf(rightTag);
                if(lastOccurence < 0) {
                    subString =  subString.substring(subString.indexOf(leftTag) + leftTag.length());
                    enter = false;
                    continue;
                }
                if(!selected && subString.lastIndexOf(rightTag) + rightTag.length() > -1) {
                    removeIndex = subString.lastIndexOf(rightTag) + rightTag.length();
                    selected = true;
                }
                enter = true;
                subString = subString.substring((subString.indexOf(leftTag) + leftTag.length()), subString.lastIndexOf(rightTag));
            }
            if(subLines.isEmpty()) subLines.add("None");
            lines.addAll(subLines);
            testCases--;
        }
        in.close();
        lines.forEach(System.out::println);
    }
}
