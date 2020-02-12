<%-- 
    Document   : register
    Created on : Feb 12, 2020, 5:17:50 PM
    Author     : Tutus W
--%>

<%@page import="java.util.List"%>
<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <style>
            * {
                box-sizing: border-box;
            }

            body {
                background-color: #f1f1f1;
            }

            #regForm {
                background-color: #ffffff;
                margin: 100px auto;
                font-family: Raleway;
                padding: 40px;
                width: 70%;
                min-width: 300px;
            }

            h1 {
                text-align: center;  
            }

            input {
                padding: 10px;
                width: 100%;
                font-size: 17px;
                font-family: Raleway;
                border: 1px solid #aaaaaa;
            }

            /* Mark input boxes that gets an error on validation: */
            input.invalid {
                background-color: #ffdddd;
            }

            /* Hide all steps by default: */
            .tab {
                display: none;
            }

            button {
                background-color: #4CAF50;
                color: #ffffff;
                border: none;
                padding: 10px 20px;
                font-size: 17px;
                font-family: Raleway;
                cursor: pointer;
            }

            button:hover {
                opacity: 0.8;
            }

            #prevBtn {
                background-color: #bbbbbb;
            }

            /* Make circles that indicate the steps of the form: */
            .step {
                height: 15px;
                width: 15px;
                margin: 0 2px;
                background-color: #bbbbbb;
                border: none;  
                border-radius: 50%;
                display: inline-block;
                opacity: 0.5;
            }

            .step.active {
                opacity: 1;
            }

            /* Mark the steps that are finished and valid: */
            .step.finish {
                background-color: #4CAF50;
            }
        </style>
        <title>Register</title>
    </head>
    <% if (session.getAttribute("skills") == null) {
            response.sendRedirect("register");
        } else {
            List<Employee> employees = (List<Employee>) session.getAttribute("regions");
            Employee employee = (Employee) session.getAttribute("updated");
    %>  
    <body>
        <form action="register" method="POST" id="regForm">
        <div class="container">

            <!--<div class="card o-hidden border-0 shadow-lg my-5">-->
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-5 d-none d-lg-block" style="padding : 5%">
                            <img src="https://www.metrodata.co.id/web/images/business/2014-08-20-112626.png">
                        </div>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="container col-sm-8">
                                    <div class="text-center">
                                        <h1>Register</h1>
                                    </div>
                                    <!-- One "tab" for each step in the form: -->
                                    <div>

                                    </div>
                                    <div class="tab">Name
                                        <div>
                                            <p><input class="form-control" placeholder="Name..." oninput="this.className = ''" name="name"></p>
                                        </div>
                                        <div>Phone Number
                                            <p><input type="number" class="form-control" placeholder="Phone Number..." oninput="this.className = ''" name="phoneNumber"></p>
                                        </div>
                                        <div>Hire Date
                                            <p><input type="date" class="form-control" placeholder="Hire Date..." oninput="this.className = ''" name="hireDate"></p>
                                        </div>
                                    </div>
                                    <div class="tab">        

                                        <div>University
                                            <p><input class="form-control" placeholder="University..." oninput="this.className = ''" name="university"></p>
                                        </div>
<!--/*                                        <div>Skills
                                            <p>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" name="skills" value="<%= //(employee != null) ? employee.getId() : ""%>" >Java
                                                </label>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" name="skills" >.Net
                                                </label><br>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" name="skills">Angular
                                                </label>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" name="skills">Php
                                                </label><br>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" name="skills">Phyton
                                                </label>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" name="skills">HTML
                                                </label>
                                            </p>
                                        </div>-->*/

                                    </div>
                                    <div class="tab">
                                        <div>Email
                                            <p><input type="email" class="form-control" placeholder="Email..." oninput="this.className = ''" name="email"></p>
                                        </div>
                                        <div>Password
                                            <p><input class="form-control" placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                                        </div>
                                    </div>
                                    <div style="overflow:auto;">
                                        <div style="float:right;">
                                            <button type="button" id="prevBtn" onclick="nextPrev(-1)" class="btn btn-primary btn-user btn-block">Previous</button>
                                            <button type="button" id="nextBtn" onclick="nextPrev(1)" class="btn btn-primary btn-user btn-block">Next</button>
                                        </div>
                                    </div>
                                    <!-- Circles which indicates the steps of the form: -->
                                    <div style="text-align:center;margin-top:40px;">
                                        <span class="step"></span>
                                        <span class="step"></span>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="login.jsp">Already have an account? Login!</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            <!--</div>-->

        </div>
            </form>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <script>
                                            var currentTab = 0; // Current tab is set to be the first tab (0)
                                            showTab(currentTab); // Display the current tab

                                            function showTab(n) {
                                                // This function will display the specified tab of the form...
                                                var x = document.getElementsByClassName("tab");
                                                x[n].style.display = "block";
                                                //... and fix the Previous/Next buttons:
                                                if (n == 0) {
                                                    document.getElementById("prevBtn").style.display = "none";
                                                } else {
                                                    document.getElementById("prevBtn").style.display = "inline";
                                                }
                                                if (n == (x.length - 1)) {
                                                    document.getElementById("nextBtn").innerHTML = "Submit";
                                                } else {
                                                    document.getElementById("nextBtn").innerHTML = "Next";
                                                }
                                                //... and run a function that will display the correct step indicator:
                                                fixStepIndicator(n)
                                            }

                                            function nextPrev(n) {
                                                // This function will figure out which tab to display
                                                var x = document.getElementsByClassName("tab");
                                                // Exit the function if any field in the current tab is invalid:
                                                if (n == 1 && !validateForm())
                                                    return false;
                                                // Hide the current tab:
                                                x[currentTab].style.display = "none";
                                                // Increase or decrease the current tab by 1:
                                                currentTab = currentTab + n;
                                                // if you have reached the end of the form...
                                                if (currentTab >= x.length) {
                                                    // ... the form gets submitted:
                                                    document.getElementById("regForm").submit();
                                                    return false;
                                                }
                                                // Otherwise, display the correct tab:
                                                showTab(currentTab);
                                            }

                                            function validateForm() {
                                                // This function deals with validation of the form fields
                                                var x, y, i, valid = true;
                                                x = document.getElementsByClassName("tab");
                                                y = x[currentTab].getElementsByTagName("input");
                                                // A loop that checks every input field in the current tab:
                                                for (i = 0; i < y.length; i++) {
                                                    // If a field is empty...
                                                    if (y[i].value == "") {
                                                        // add an "invalid" class to the field:
                                                        y[i].className += " invalid";
                                                        // and set the current valid status to false
                                                        valid = false;
                                                    }
                                                }
                                                // If the valid status is true, mark the step as finished and valid:
                                                if (valid) {
                                                    document.getElementsByClassName("step")[currentTab].className += " finish";
                                                }
                                                return valid; // return the valid status
                                            }

                                            function fixStepIndicator(n) {
                                                // This function removes the "active" class of all steps...
                                                var i, x = document.getElementsByClassName("step");
                                                for (i = 0; i < x.length; i++) {
                                                    x[i].className = x[i].className.replace(" active", "");
                                                }
                                                //... and adds the "active" class on the current step:
                                                x[n].className += " active";
                                            }
        </script>
    </body>
</html>
