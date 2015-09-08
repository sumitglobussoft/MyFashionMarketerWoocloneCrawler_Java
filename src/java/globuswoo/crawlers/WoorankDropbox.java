/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

/**
 *
 * @author GLB-214
 */
public class WoorankDropbox {

    public String iphoneView = "NA";
    public String ipadView = "NA";
    public String dashboardImage = "NA";
    public String usabilityImage = "NA";
    private static final String DROP_BOX_APP_KEY = "mm6bomjjc8jbsa7";
    private static final String DROP_BOX_APP_SECRET = "wbzbsspb18r4ip3";
    static DbxClient dbxClient;
    static DbxRequestConfig dbxRequestConfig = new DbxRequestConfig(
            "JavaDropboxTutorial/1.0", Locale.getDefault().toString());

    public static DbxClient authDropbox(String dropBoxAppKey, String dropBoxAppSecret)
            throws IOException, DbxException {

        String authAccessToken = "L-AsGQ7r-_EAAAAAAAAAVVQEOjHQUzXlmXb_EYjgiHuIOrXAlFZp3h6XcV4k3ZM7";
        dbxClient = new DbxClient(dbxRequestConfig, authAccessToken);
        System.out.println("Dropbox Account Name: "
                + dbxClient.getAccountInfo().displayName);

        return dbxClient;
    }

    public void woorankImages(String getUrl_Domain, String url) throws IOException, DbxException {
        String url_Domain = getUrl_Domain.replace("http://www.", "");
//        String url = "socioboard.com";
//*******************************CODE FOR IPHONE IMAGE**************************
        try {
            authDropbox(DROP_BOX_APP_KEY, DROP_BOX_APP_SECRET);
            File inputFile = new File("C:\\inetpub\\globustracker\\Globuswooclonecrawler\\temp\\" + url_Domain + ".iphone.png");
            FileInputStream inputStream = new FileInputStream(inputFile);
            try {
                DbxEntry.File uploadedFile = dbxClient.uploadFile("/Globustracker/Images/" + url_Domain + ".iphone.png",
                        DbxWriteMode.add(), inputFile.length(), inputStream);
                String fileName = "Globustracker/Images/" + url_Domain + ".iphone.png";
                String iphoneView2 = dbxClient.createShareableUrl("/" + fileName);
                iphoneView = "" + iphoneView2.replace("https://www.dropbox.com/", "https://dl.dropboxusercontent.com/");
                System.out.println("======IPHONE SHARED URL========" + iphoneView);
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
        }
//*******************************CODE FOR IPAD IMAGE****************************
        try {
            authDropbox(DROP_BOX_APP_KEY, DROP_BOX_APP_SECRET);
            File inputFile1 = new File("C:\\inetpub\\globustracker\\Globuswooclonecrawler\\temp\\" + url_Domain + ".ipad.png");
            FileInputStream inputStream1 = new FileInputStream(inputFile1);
            try {
                DbxEntry.File uploadedFile1 = dbxClient.uploadFile("/Globustracker/Images/" + url_Domain + ".ipad.png",
                        DbxWriteMode.add(), inputFile1.length(), inputStream1);
                String fileName = "Globustracker/Images/" + url_Domain + ".ipad.png";
                String ipadView2 = dbxClient.createShareableUrl("/" + fileName);
                ipadView = "" + ipadView2.replace("https://www.dropbox.com/", "https://dl.dropboxusercontent.com/");
                System.out.println("======IPAD SHARED URL========" + ipadView);
            } finally {
                inputStream1.close();
            }
        } catch (Exception e) {
        }
//*******************************CODE FOR DASHBOARD IMAGE***********************
        try {
            authDropbox(DROP_BOX_APP_KEY, DROP_BOX_APP_SECRET);
            File inputFile2 = new File("C:\\inetpub\\globustracker\\Globuswooclonecrawler\\temp\\" + url_Domain + ".png");
            FileInputStream inputStream2 = new FileInputStream(inputFile2);
            try {
                DbxEntry.File uploadedFile2 = dbxClient.uploadFile("/Globustracker/Images/" + url_Domain + ".png",
                        DbxWriteMode.add(), inputFile2.length(), inputStream2);
                String fileName = "Globustracker/Images/" + url_Domain + ".png";
                String dashboardImage2 = dbxClient.createShareableUrl("/" + fileName);
                String usabilityImage2 = dbxClient.createShareableUrl("/" + fileName);
                dashboardImage = dashboardImage2.replace("https://www.dropbox.com/", "https://dl.dropboxusercontent.com/");
                usabilityImage = usabilityImage2.replace("https://www.dropbox.com/", "https://dl.dropboxusercontent.com/");
                System.out.println("======DASHBOARD SHARED URL========" + dashboardImage);
                System.out.println("======DASHBOARD SHARED URL========" + usabilityImage);
            } finally {
                inputStream2.close();
            }
        } catch (Exception e) {
        }
    }
}

//   public static void main(String[] args) throws IOException, DbxException {
//        WoorankDropbox objWoorankDropbox = new WoorankDropbox();
//        objWoorankDropbox.woorankImages("socioboard.com");
