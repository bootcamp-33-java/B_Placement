/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;
import models.Batch;
import models.Employee;
import models.Skill;
import models.SkillSet;
import models.StudyClass;
import tools.HibernateUtil;

/**
 *
 * @author Tutus W
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private final GeneralDAO<Account> adao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Account.class);
    private final GeneralDAO<Employee> edao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Employee.class);
    private final GeneralDAO<Skill> sdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Skill.class);
    private final GeneralDAO<Batch> bdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Batch.class);
    private final GeneralDAO<SkillSet> ssdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), SkillSet.class);
    private final GeneralDAO<StudyClass> scdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), StudyClass.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.getSession().setAttribute("employee", edao.getData(null));
            request.getSession().setAttribute("account", adao.getData(null));
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String skill = request.getParameter("skill");
        String batch = request.getParameter("batch");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String hireDate = request.getParameter("hire_date");
        String isActive = request.getParameter("isActive");
        String password = request.getParameter("password");
        String university = request.getParameter("university");
        String idSkill = request.getParameter("id");
        String idSkillSet = request.getParameter("id");
        String nameSkill = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String room = request.getParameter("room");
        String nameClass = request.getParameter("name");
        
        Employee employee = new Employee(id, name, phoneNumber, 
                email, Date.valueOf(hireDate), new Short("0"), university);
        edao.saveOrDelete(employee, false);
        
        int n=70;
        List<Employee> emp = edao.getData(id);
        List<Skill> sk = sdao.getData(id);
        List<Batch> bs =bdao.getData(id);
        List<SkillSet> ss = ssdao.getData(id);
//        
//        String pass= BCrypt.hashpw(password, BCrypt.gensalt());
        
        Account account = new Account(emp.get(0).getId(), password, new Short("0"), RegisterServlet.getAlphaNumericString(n));
        adao.saveOrDelete(account, false);
        
        Skill s = new Skill(sk.get(0).getId(), sk.get(0).getName());
        sdao.saveOrDelete(s, false);
        
        Batch b = new Batch(Integer.parseInt(id), Date.valueOf(startDate), Date.valueOf(endDate));
        bdao.saveOrDelete(b, false);
        
        SkillSet skillSet = new SkillSet(Integer.parseInt(id), new Employee(emp.get(0).getId()), new Skill(skill));
        ssdao.saveOrDelete(skillSet, false);
        
        StudyClass studyClass = new StudyClass(Integer.parseInt(id), nameClass, room);
        scdao.saveOrDelete(studyClass, false);
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    static String getAlphaNumericString(int n) {

        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
