package com.genusIIc.vt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;

public class ComparisonDoc {
    private static final Logger logger = LogManager.getLogger(ComparisonDoc.class);
    private void checkingFiles(String org, String mdf) {
        if(!(new File(org).exists() && new File(mdf).exists())) {
            System.out.println();
            logger.error("A non-existent file is entered in the parameters");
        }

        if (org.equals(mdf)) {
            System.out.println();
            logger.error("The same file was entered in the parameters");
        }
    }

    public <T> List<String> compare(String org, String mdf){
        checkingFiles(org, mdf);

        List<String> list = new ArrayList<>();

        try(BufferedReader br_1 = new BufferedReader(new FileReader(org));
            BufferedReader br_2 = new BufferedReader(new FileReader(mdf))){

            logger.info("File comparison started.");

            int i = 1;
            String orgFile, mdfFile;

            logger.info("Files are being compared.");

            while (((orgFile = br_1.readLine()) != null)
                    && ((mdfFile = br_2.readLine()) != null)) {
                if (!orgFile.equals(mdfFile)) {
                    list.add(orgFile+" => "+mdfFile);
                }
                i++;
            }
            logger.info("File comparison ended.");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return list;
    }
}
