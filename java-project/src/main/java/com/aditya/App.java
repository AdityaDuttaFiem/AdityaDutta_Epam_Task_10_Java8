package com.aditya;

import java.util.*;

interface Task3Lambda {
ArrayList<String> palin(ArrayList<String> x);
}

@FunctionalInterface
interface avgLambda {
double avg(ArrayList<Integer> x);
}

public class App {

public static void main(String[] args) {
//Task1
Task1 ob1=new Task1();ob1.exec();
System.out.println();

//Task2
Task2 ob2=new Task2();ob2.exec();
System.out.println();

//Task3
Task3Lambda ref=Task3::palin;
ArrayList<String> x=new ArrayList<String>();
x.add("abc");x.add("aba");x.add("abba");
ArrayList<String> X=ref.palin(x);
System.out.print("Task3 ....Original--abc,aba,abba   New--");
for(String a:X)System.out.print(a+",");


}

}

 class Task1 {
void exec(){
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(1);l.add(2);
   avgLambda avg=(ArrayList<Integer> x)->{
       double tot=0.0;
       for(int i=0;i<x.size();i++)tot+=x.get(i);
       return tot/x.size();
   };
   System.out.println("Task 1 List average for {1,2}="+avg.avg(l));
}
}

class Task2 {
void exec() {
List<String> names=new ArrayList<String>();
names.add("abb");names.add("abcd");names.add("cbb");
System.out.print("Task2 original-abb,abcd,cbb  new-");
names.stream()
.filter(str->str.startsWith("a"))
.filter(str->str.length()==3)
.forEach(str->System.out.print(str+","));

System.out.println();
}
}

class Task3 {
static ArrayList<String> palin(ArrayList<String> x){
ArrayList<String> ans=new ArrayList<String>();
for(int i=0;i<x.size();i++)
if(ispalin(x.get(i)))
ans.add(x.get(i));
return ans;
}
static boolean ispalin(String x) {
String rev="";
for(int i=x.length()-1;i>-1;i--)rev+=x.charAt(i);
return rev.equals(x);
}
}
