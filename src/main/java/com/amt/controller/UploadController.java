package com.amt.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

@MultipartConfig
@WebServlet("/upload.do")
public class UploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Part myFile = req.getPart("file");

        // get filename and gen uuid filename
        String fileName = myFile.getSubmittedFileName();
        String randomString = UUID.randomUUID().toString();
        String extName = fileName.substring(fileName.indexOf("."));
        String uuidFilename = randomString + extName;

        // get file path
        String severPath = req.getServletContext().getRealPath("/uploadimg");

        // upload
        String uploadPath = severPath + "/" + uuidFilename;
        myFile.write(uploadPath);

        // save map
        HashMap<String, String> map = new HashMap<String, String>();
        String getServerPath = req.getContextPath() + "/uploadimg/" + uuidFilename;
        map.put("imgurl", getServerPath);
        map.put("imgname", uuidFilename);

        String str = JSON.toJSONString(map);
        out.write(str);
        out.close();


    }
}
