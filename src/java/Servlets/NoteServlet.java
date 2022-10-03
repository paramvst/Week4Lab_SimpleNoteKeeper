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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String edit = request.getParameter("edit");
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        if (edit != null) {
            Note editNote = new Note(path);
            
            
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