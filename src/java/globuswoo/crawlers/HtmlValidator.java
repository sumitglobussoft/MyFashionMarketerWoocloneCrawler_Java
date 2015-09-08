/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

/**
 *
 * @author GLB-214
 */
import globuswoo.entity.Commonseo;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;

public class HtmlValidator {

    public int totaltags = 0;
    public int correcttags = 0;
    public int incorrecttags = 0;

    public int passedpercentage = 0;
    public int toimprovepercentage = 0;
    public int errorpercentage = 0;
    private Pattern pattern;
    private Matcher matcher;

    private static final String HTML_TAG_FORMAT_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";

    public HtmlValidator() {
        pattern = Pattern.compile(HTML_TAG_FORMAT_PATTERN);
    }

    public boolean validate(final String tag) {

        matcher = pattern.matcher(tag);
        return matcher.matches();

    }

//    public static void main(String[] args) throws IOException {
//        HtmlValidator t = new HtmlValidator();
//
//        t.data("http://www.ebay.com");
//    }
    public void disp() {

        System.out.println("PASSED PERCENTAGE : " + passedpercentage);
        System.out.println("TO IMPROVE PERCENTAGE : " + toimprovepercentage);
        System.out.println("ERROR PERCENTAGE : " + errorpercentage);
    }

    public void getDetails(Document doc, Commonseo data, String complete_url) throws IOException {

        try {
            String result = Crawler.fetchGooglePageRank(complete_url);
            result = result.replace(">", ">\n");
//            System.out.println(result);
            int count = 0;

//            System.out.println("count" + count);
            String strLine[] = result.split("\n");

            for (String string : strLine) {
                totaltags++;
//                System.out.println("-- line " + totaltags + " --" + validate(string));
                if (validate(string)) {
                    correcttags++;
                } else {
                    incorrecttags++;
                }

            }

            errorpercentage = (correcttags * 100 / totaltags);

            passedpercentage = 100 - errorpercentage;

            int temp;

            if (errorpercentage > passedpercentage) {
                temp = errorpercentage;
                errorpercentage = passedpercentage;
                passedpercentage = temp;
            }

            toimprovepercentage = errorpercentage / 2;

            System.out.println("passedpercentage : " + passedpercentage);
            System.out.println("errorpercentage : " + errorpercentage);
            System.out.println("toimprovepercentage : " + toimprovepercentage);

            new File("temp.log").delete();
        } catch (Exception e) {
        }

        data.setPassedPercent(passedpercentage);
        data.setErrorPercent(errorpercentage);
        data.setImprovePercent(toimprovepercentage);
    }

}
