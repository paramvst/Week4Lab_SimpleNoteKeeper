/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Note;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author param
 */
public class NoteServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NoteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NoteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String edit = request.getParameter("edit");
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        if (edit != null) {
            Note editNote = new Note(path);
            
            String formattedTitle = editNote.getTitle().replaceAll("<br>", "\r\n");
            editNote.setTitle(formattedTitle);
            
            
            // Replace any html line breaks with regular line breaks
            String formattedContents = editNote.getContents().replaceAll("<br>", "\r\n");
            editNote.setContents(formattedContents);
            
            request.setAttribute("note", editNote);
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").
                    forward(request, response);
        } else {
            Note viewNote = new Note(path);
            
            request.setAttribute("note", viewNote);
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").
                forward(request, response);
        }
   }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        String formattedTitle = request.getParameter("formattedTitle");
        String formattedContents = request.getParameter("formattedContents");
        
        Note editNote = new Note(path);
        
        editNote.setTitle(formattedTitle);
        editNote.setContents(formattedContents);
        
        request.setAttribute("note",editNote);
        editNote.saveNote(path);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").
                forward(request, response);
                
    }

    

}