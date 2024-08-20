package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

public class HtmlGenerator {

  // return html in string
  public static String generateHtmlFromPdf(InputStream inputStream) throws IOException {
   PDDocument pdf = PDDocument.load(inputStream);
   PDFDomTree parser = new PDFDomTree();
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   Writer output = new PrintWriter(baos, true, StandardCharsets.UTF_8);
   parser.writeText(pdf, output);
   output.close();
   pdf.close();
   return new String(baos.toByteArray(), StandardCharsets.UTF_8);
  }
}