/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

/**
 * Entity class for saving Account module data
 *
 * @author Kalpana Nagle <kalpana@globussoft.com>
 */
public class Account {

    private String planName;
    private String campaignDetail;
    private String keywordDetail;
    private String userDetail;

    /**
     *
     * @return
     */
    public String getPlanName() {
        return planName;
    }

    /**
     *
     * @param planName
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     *
     * @return
     */
    public String getCampaignDetail() {
        return campaignDetail;
    }

    /**
     *
     * @param campaignDetail
     */
    public void setCampaignDetail(String campaignDetail) {
        this.campaignDetail = campaignDetail;
    }

    /**
     *
     * @return
     */
    public String getKeywordDetail() {
        return keywordDetail;
    }

    /**
     *
     * @param keywordDetail
     */
    public void setKeywordDetail(String keywordDetail) {
        this.keywordDetail = keywordDetail;
    }

    /**
     *
     * @return
     */
    public String getUserDetail() {
        return userDetail;
    }

    /**
     *
     * @param userDetail
     */
    public void setUserDetail(String userDetail) {
        this.userDetail = userDetail;
    }
}
