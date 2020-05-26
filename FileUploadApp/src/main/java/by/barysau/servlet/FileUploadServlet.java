package by.barysau.servlet;

import by.barysau.service.DoGetService;
import by.barysau.service.DoPostService;
import by.barysau.service.impl.DoGetServiceImpl;
import by.barysau.service.impl.DoPostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = {"/upload", "/index.jsp"})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Part filePart = req.getPart("file");
        DoPostService doPostService = new DoPostServiceImpl();
        req.setAttribute("message", doPostService.uploadFile(filePart));
        doGet(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DoGetService doGetService = new DoGetServiceImpl();
        req.setAttribute("fileList", doGetService.getFilesList());
        req.getRequestDispatcher("WEB-INF/upload.jsp").forward(req, resp);

    }

}

