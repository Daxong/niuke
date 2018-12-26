package niuke;

import java.util.*;
import java.util.regex.Pattern;

/**
 * calculate math expression
 * 2+3*3-4(2/1)
 */
public class Calculator {
    public static int calc(String expression) {
        Stack<String> integers = new Stack<>();
        boolean num_flag = false;
        String num = "";
        for (int i = 0 ; i < expression.length() ; i++) {
            // judge the index yes or not a number
            if (Character.isDigit(expression.charAt(i))) {
                String temp = expression.charAt(i)+""; // convert char to String
                if (num_flag == true) {
                    num += temp;
                }else {
                    num = temp;
                }
                num_flag = true;
            }else {
                if (!num.equals("")) {
                    System.out.println(Integer.valueOf(num));
                }
                integers.push(num);//press number in stack

                num = "";
                num_flag = false;
            }

        }
        return 1;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double res = calculator.calcWithStack("56*(3-2)+2*(2+3)");
        System.out.println(res);
    }

    public double calcWithStack(String expresion) {
        StringTokenizer tokenizer = new StringTokenizer(expresion,"+-*/()",true);
        Stack<Double> numStack = new Stack<>();
        Stack<Operator> operStack = new Stack<>();
        Map<String,Operator> computeOper = this.getComputerOper();
        String currentEle;
        while (tokenizer.hasMoreTokens()) {
            currentEle = tokenizer.nextToken().trim();
            if (!"".equals(currentEle)) {
                if (this.isNum(currentEle)) {
                    numStack.push(Double.valueOf(currentEle));
                } else {
                  Operator currentOper = computeOper.get(currentEle);
                  if (currentOper != null) {
                      while (!operStack.empty() && operStack.peek().priority() >= currentOper.priority()) {
                          compute(numStack, operStack);
                      }
                      operStack.push(currentOper);
                  } else {
                      if ("(".equals(currentEle)) {
                          operStack.push(Operator.BRACKETS);
                      } else {
                          while (!operStack.peek().equals(Operator.BRACKETS)) {
                              compute(numStack, operStack);
                          }
                          operStack.pop();
                      }
                  }
                }
            }
        }
        while (!operStack.empty()) {
            compute(numStack, operStack);
        }
        return numStack.pop();
    }

    private boolean isNum(String str) {
        String numRegex = "^\\d+(\\.\\d+)?$"; // regular expression of number
        return Pattern.matches(numRegex, str);
    }

    private Map<String, Operator> getComputerOper() {
        return new HashMap<String, Operator>() {
            private static final long serialVersionUID = 7706718608122369958L;
            {
                put("+", Operator.PLUS);
                put("-", Operator.MINUS);
                put("*", Operator.MULTIPLY);
                put("/", Operator.DIVIDE);
            }
        };
    }

    private void compute(Stack<Double> numStack, Stack<Operator> operStack) {
        Double num2 = numStack.pop(); // 弹出数字栈最顶上的数字作为运算的第二个数字
        Double num1 = numStack.pop(); // 弹出数字栈最顶上的数字作为运算的第一个数字
        Double computeResult = operStack.pop().compute(num1, num2); // 弹出操作栈最顶上的运算符进行计算
        numStack.push(computeResult); // 把计算结果重新放到队列的末端
    }

    private enum Operator {
        PLUS {
            public int priority() {
                return 1;
            }

            public double compute(double num1, double num2) {
                return num1 + num2;
            }
        },

        MINUS {
            public  int priority() {
                return 1;
            }

            public  double compute(double num1, double num2) {
                return num1 - num2;
            }
        },
        MULTIPLY {
            public int priority() {
                return 2;
            }
            public double compute(double num1, double num2) {
                return num1 * num2;
            }
        },
        DIVIDE {
            public int priority() {
                return 2;
            }
            public double compute(double num1, double num2) {
                return num1 / num2;
            }
        },
        BRACKETS {
            public int priority() {
                return 0;
            }
            public double compute(double num1, double num2) {
                return 0;
            }
        };

        public abstract int priority();
        public abstract double compute(double num1, double num2);

    }

}