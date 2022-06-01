package com.QiBaochao.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/lab3/CalServlet")
public class CalServlet extends HttpServlet {
    private int add(int firstVal,int secondVal) {
        return firstVal+secondVal;
    }
    private int Sub(int firstVal,int secondVal){
        return firstVal - secondVal;
    }
    private int Multiply(int firstVal,int secondVal){
        return firstVal * secondVal;
    }
    private double Divide(int firstVal,int secondVal){
        double  NewfirstVal = Double.parseDouble(String.valueOf(firstVal));
        double newsecondVal =  Double.parseDouble(String.valueOf(secondVal));
        return NewfirstVal / newsecondVal;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int firstVal;
        int secondVal;
        String name;
        if(action.equals("Compute Length")){
            name = request.getParameter("Name");
            Cookie nameCookie = new Cookie("cName",name);
            Cookie lengthCookie = new Cookie("cLength",Integer.toString(name.length()));
            nameCookie.setMaxAge(50);
            lengthCookie.setMaxAge(50);
            response.addCookie(nameCookie);
            response.addCookie(lengthCookie);
            System.out.println(name.length());
        }
        else {
            firstVal  = Integer.parseInt(request.getParameter("FirstVal"));
            secondVal  = Integer.parseInt(request.getParameter("SecondVal"));
            Cookie firstValCookie = new Cookie("cFirstVal",Integer.toString(firstVal));
            Cookie secondValCookie = new Cookie("cSecondVal",Integer.toString(secondVal));
            Cookie resultCookie = null;
            if (action.equals("Add")) {
                int result = add(firstVal, secondVal);
                resultCookie = new Cookie("cResult",Integer.toString(result));
                System.out.println(result);
            } else if (action.equals("Subtract")) {
                int result = Sub(firstVal, secondVal);
                resultCookie = new Cookie("cResult",Integer.toString(result));
                System.out.println(result);
            } else if (action.equals("Multiply")) {
                int result = Multiply(firstVal, secondVal);
                resultCookie = new Cookie("cResult",Integer.toString(result));
                System.out.println(result);
            } else if (action.equals("Divide")) {
                double result = Divide(firstVal, secondVal);
                resultCookie = new Cookie("cResult",Double.toString(result));
                System.out.println(result);
            }
            firstValCookie.setMaxAge(50);
            secondValCookie.setMaxAge(50);
            if(resultCookie!=null) {
                resultCookie.setMaxAge(50);
                response.addCookie(resultCookie);
            }
            response.addCookie(firstValCookie);
            response.addCookie(secondValCookie);
        }
        response.sendRedirect("cal.jsp");
    }
}