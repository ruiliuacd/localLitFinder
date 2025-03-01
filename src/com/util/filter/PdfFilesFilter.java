package com.util.filter;

import java.io.File;
import java.io.FileFilter;

public class PdfFilesFilter implements FileFilter {
    public boolean accept(File path) {
      return path.getName().toLowerCase()        //6
             .endsWith(".pdf");                  //6
    }
  }
