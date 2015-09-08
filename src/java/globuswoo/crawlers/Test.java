/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author GLB-214
 */
public class Test {

    public static void main(String[] args) throws JSONException, Exception {
        String complete_url = "http://www.flipkart.com";
        String facebook_url = "NA";
        String facebook_name = "NA";

        String temp[] = complete_url.replace(".", "#").split("#");
        facebook_url = "https://www.facebook.com/" + temp[1];
        facebook_name = temp[1];
        System.out.println("1. Facebook Name : " + facebook_name);

        String url1 = "https://graph.facebook.com/" + facebook_name + "?access_token=CAANGZCSfBfk0BAMWQuyJsKTspZB1ms7PILEPyYuQ1ZClJ9CUgX8MOJcSE6bEkYGlsSXxPe0T3gqkMLNm2NpRFuipGWqZBtuKAlXZAIR5nhGACl2GYjpNxyYkN6nonWED9MwK3uDVbXOfZAJceu3vzuJCQm4NZBb7fZBOKOuC2o7zAv7Dj2Y0VGsFMrjZBbL0aVzMZD";

        JSONObject json = new JSONObject(new GetRequestHandler().doGetRequest(new URL(url1)));

        facebook_url = json.getString("website");
        System.out.println("2. facebook_url : " + facebook_url);

        String facebook_about = json.getString("about");
        System.out.println("3. facebook_about : " + facebook_about);

        String facebook_overview = json.getString("company_overview");
        System.out.println("4. facebook_overview : " + facebook_overview);

        String facebook_image = json.getJSONObject("cover").getString("source");
        System.out.println("facebook_image : " + facebook_image);

        String facebook_founded = json.getString("founded");
        System.out.println("5. Facebook FOunded : " + facebook_founded);

        Object facebooklikes = json.get("likes");
        String facebook_likes = facebooklikes.toString();
        System.out.println("6. Facebook likes : " + facebook_likes);

        String facebook_links = json.getString("link");
        System.out.println("7. Facebook Links : " + facebook_links);

        String facebook_city = json.getJSONObject("location").getString("city");
        System.out.println("8. facebook_city : " + facebook_city);

        String facebook_country = json.getJSONObject("location").getString("country");
        System.out.println("9. facebook_country : " + facebook_country);

        String facebook_state = json.getJSONObject("location").getString("state");
        System.out.println("10. facebook_state : " + facebook_state);

        String facebook_street = json.getJSONObject("location").getString("street");
        System.out.println("11. facebook_street : " + facebook_street);

        String facebook_zip = json.getJSONObject("location").getString("zip");
        System.out.println("12. facebook_zip : " + facebook_zip);

        Object talkingaboutcount = json.get("talking_about_count");
        String talking_about_count = talkingaboutcount.toString();
        System.out.println("13. talking_about_count : " + talking_about_count);
        
        String  facebookDescription = json.getString("description");
        System.out.println("14. facebookDescription : " + facebookDescription);

//        String facebook_share_count = "NA";
//        String facebook_like_count = "NA";
//        String facebook_comment_count = "NA";
//        String facebook_total_count = "NA";
//        String facebook_click_count = "NA";
//        String facebook_commentsbox_count = "NA";
//        String linkedin_count = "NA";
//
//        String complete_url = "ebay.com";
//
//        String facebookurl = "http://api.facebook.com/restserver.php?format=json&method=links.getStats&urls="
//                + complete_url;
//
//        JSONArray result = new JSONArray(new GetRequestHandler().doGetRequest(new URL(facebookurl)));
//        JSONObject json = result.getJSONObject(0);
//        
//        try {
//            Pattern pattern = Pattern.compile("share_count(.*?),");
//            Matcher matcher = pattern.matcher((CharSequence) json);
//            if (matcher.find()) {
//                String temp_share_count = matcher.group(1).replace("\":", "").trim();
//                Integer share_count = Integer.parseInt(temp_share_count);
//                System.out.println(share_count);
////                result[0] = share_count;
//            }
//        } catch (Exception e) {
//          
//        }
//        try {
//            Object facebook_click_count_no = json.get("click_count");
//            facebook_click_count = json.get("click_count").toString();
//            System.out.println("click_count : " + facebook_click_count);
//        } catch (Exception e) {
//        }
//
//        try {
//            Object facebook_comment_count_no = json.get("comment_count");
//            facebook_comment_count = json.get("comment_count").toString();
//            System.out.println("comment_count : " + facebook_comment_count);
//        } catch (Exception e) {
//        }
//
//        try {
//            Object commentsbox_count_no = json.get("commentsbox_count");
//            facebook_commentsbox_count = json.get("commentsbox_count").toString();
//            System.out.println("commentsbox_count : " + facebook_commentsbox_count);
//        } catch (Exception e) {
//        }
//
//        try {
//            Object facebook_like_count_no = json.get("like_count");
//            facebook_like_count = json.get("like_count").toString();
//            System.out.println("like_count : " + facebook_like_count);
//        } catch (Exception e) {
//        }
//
//        try {
//            Object facebook_share_count_no = json.get("share_count");
//            facebook_share_count = json.get("share_count").toString();
//            System.out.println("share_count : " + facebook_share_count);
//        } catch (Exception e) {
//        }
//
//        try {
//            Object facebook_total_count_no = json.get("total_count");
//            facebook_total_count = json.get("total_count").toString();
//            System.out.println("total_count : " + facebook_total_count);
//        } catch (Exception e) {
//        }
//        String url = "http://api.facebook.com/restserver.php?format=json&method=links.getStats&urls=http://www." + facebook_name;
//
//        JSONArray result = new JSONArray(new GetRequestHandler().doGetRequest(new URL(url)));
//       
//        JSONObject json = result.getJSONObject(0);
//
//        Object facebook_click_count = json.get("click_count");
//        System.out.println("click_count : " + facebook_click_count);
//
//        Object facebook_comment_count = json.get("comment_count");
//        System.out.println("comment_count : " + facebook_comment_count);
//      
//        Object commentsbox_count = json.get("commentsbox_count");
//        System.out.println("commentsbox_count : " + commentsbox_count);
//
//        Object facebook_like_count = json.get("like_count");
//        System.out.println("like_count : " + facebook_like_count);
//
//        Object facebook_share_count = json.get("share_count");
//        System.out.println("share_count : " + facebook_share_count);
//
//        Object facebook_total_count = json.get("total_count");
//        System.out.println("total_count : " + facebook_total_count);
//
//        Object url1 = json.get("url");
//        System.out.println("url : " + url1);
//        
//        Object normalized_url = json.get("normalized_url");
//        System.out.println("normalized_url : " + normalized_url);
    }
}
