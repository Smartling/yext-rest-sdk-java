package com.smartling.connector.yext.sdk.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Location
{
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String faxPhone;

    private Headshot headshot;

    private List<String> keywords;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String tollFreePhone;

    private List<String> menuIds;

    /**
     * Gets or Sets trackingSites
     */
    public enum TrackingSitesEnum
    {
        GOOGLE_DESKTOP("GOOGLE_DESKTOP"),

        GOOGLE_MOBILE("GOOGLE_MOBILE"),

        BING_DESKTOP("BING_DESKTOP"),

        YAHOO_DESKTOP("YAHOO_DESKTOP");

        private String value;

        TrackingSitesEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private List<TrackingSitesEnum> trackingSites;

    private String middleName;

    private String additionalHoursText;

    private String featuredMessageUrl;

    private String reservationUrl;

    private List<String> degrees;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> labelIds;

    private String googlePreferredPhoto;

    private List<String> videoUrls;

    private String featuredMessage;

    private Double yextDisplayLat;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String mobilePhone;

    private ServiceArea serviceArea;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long timestamp;

    private String address2;

    private FacebookCoverPhoto facebookCoverPhoto;

    private Double yextWalkableLat;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> bioListIds;

    private String facebookPageUrl;

    private List<String> emails;

    private Double walkableLng;

    /**
     * The gender of the healthcare professional  **NOTE:** This field is only available to locations whose **locationType** is HEALTHCARE_PROFESSIONAL.
     */
    public enum GenderEnum
    {
        FEMALE("FEMALE"),

        F("F"),

        MALE("MALE"),

        M("M"),

        UNSPECIFIED("UNSPECIFIED");

        private String value;

        GenderEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private GenderEnum gender;

    private String websiteUrl;

    private List<String> specialties;

    private String bioListsLabel;

    private Double displayLng;

    private Double yextPickupLng;

    private List<String> productListIds;

    private GoogleCoverPhoto googleCoverPhoto;

    private List<EducationList> educationList;

    private Double pickupLat;

    private Logo logo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String alternatePhone;

    private String accountId;

    private String menuUrl;

    private Boolean acceptingNewPatients;

    private String displayWebsiteUrl;

    private Double yextRoutableLng;

    private String state;

    private Boolean suppressAddress;

    private Object closed;

    private String displayMenuUrl;

    private String officeName;

    private Double yextDropoffLat;

    private String hours;

    private String address;

    private String uberLink;

    private String uberClientId;

    private FacebookProfilePicture facebookProfilePicture;

    private List<String> certifications;

    private String language;

    private String lastName;

    private String locationName;

    /**
     * Gets or Sets queryTemplates
     */
    public enum QueryTemplatesEnum
    {
        KEYWORD("KEYWORD"),

        KEYWORD_ZIP("KEYWORD_ZIP"),

        KEYWORD_CITY("KEYWORD_CITY"),

        KEYWORD_IN_CITY("KEYWORD_IN_CITY"),

        KEYWORD_NEAR_ME("KEYWORD_NEAR_ME"),

        KEYWORD_CITY_STATE("KEYWORD_CITY_STATE");

        private String value;

        QueryTemplatesEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private List<QueryTemplatesEnum> queryTemplates;

    private List<String> products;

    private String uberLinkText;

    private List<Object> googleAttributes;

    private List<String> paymentOptions;

    private List<String> customKeywords;

    private Double dropoffLng;

    private Boolean intelligentSearchTrackingEnabled;

    private String uberEmbedCode;

    private String displayReservationUrl;

    private Double yextDisplayLng;

    private String displayAddress;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> categoryIds;

    private String productListsLabel;

    private String city;

    private String menusLabel;

    private String zip;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String localPhone;

    private String orderUrl;

    private Double dropoffLat;

    private List<String> conditionsTreated;

    private Double pickupLng;

    private Map<String, Object> customFields;

    private Double walkableLat;

    private List<String> insuranceAccepted;

    /**
     * Indicates whether the embedded Uber link for this location appears as text or a button  When consumers click on this link on a mobile device, the Uber app (if installed)
     * will open with your location set as the trip destination. If the Uber app is not installed, the consumer will be prompted to download it.
     */
    public enum UberLinkTypeEnum
    {
        LINK("LINK"),

        BUTTON("BUTTON");

        private String value;

        UberLinkTypeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private UberLinkTypeEnum uberLinkType;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String folderId;

    private GoogleProfilePhoto googleProfilePhoto;

    private String instagramHandle;

    private String eventListsLabel;

    private List<Object> holidayHours;

    private String firstName;

    private List<String> languages;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocationType locationType;

    public enum LocationType
    {

        LOCATION("LOCATION"),

        HEALTHCARE_PROFESSIONAL("HEALTHCARE_PROFESSIONAL"),

        HEALTHCARE_FACILITY("HEALTHCARE_FACILITY");

        private String value;

        LocationType(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private List<String> admittingHospitals;

    private String yearEstablished;

    private Double yextWalkableLng;

    private List<String> associations;

    private Double routableLng;

    private String countryCode;

    private Double yextPickupLat;

    /**
     * Gets or Sets locationKeywords
     */
    public enum LocationKeywordsEnum
    {
        NAME("NAME"),

        PRIMARY_CATEGORY("PRIMARY_CATEGORY");

        private String value;

        LocationKeywordsEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private List<LocationKeywordsEnum> locationKeywords;

    private String googleWebsiteOverride;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    private List<String> alternateWebsites;

    /**
     * How often we send search queries to track your search performance.
     */
    public enum IntelligentSearchTrackingFrequencyEnum
    {
        WEEKLY("WEEKLY"),

        MONTHLY("MONTHLY"),

        QUARTERLY("QUARTERLY");

        private String value;

        IntelligentSearchTrackingFrequencyEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private IntelligentSearchTrackingFrequencyEnum intelligentSearchTrackingFrequency;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> eventListIds;

    private Double displayLat;

    private List<Object> competitors;

    private Double yextDropoffLng;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isPhoneTracked;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String ttyPhone;

    private String npi;

    private String description;

    private String twitterHandle;

    private List<String> brands;

    private String uberTripBrandingUrl;

    private Double routableLat;

    private Double yextRoutableLat;

    private List<String> alternateNames;

    private List<Photo> photos;

    private String displayOrderUrl;

    private List<String> services;

    private String sublocality;

    private String uberTripBrandingText;

    private String uberTripBrandingDescription;


    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public String getFaxPhone()
    {
        return faxPhone;
    }

    public void setFaxPhone(final String faxPhone)
    {
        this.faxPhone = faxPhone;
    }

    public Headshot getHeadshot()
    {
        return headshot;
    }

    public void setHeadshot(final Headshot headshot)
    {
        this.headshot = headshot;
    }

    public List<String> getKeywords()
    {
        return keywords;
    }

    public void setKeywords(final List<String> keywords)
    {
        this.keywords = keywords;
    }

    public String getTollFreePhone()
    {
        return tollFreePhone;
    }

    public void setTollFreePhone(final String tollFreePhone)
    {
        this.tollFreePhone = tollFreePhone;
    }

    public List<String> getMenuIds()
    {
        return menuIds;
    }

    public void setMenuIds(final List<String> menuIds)
    {
        this.menuIds = menuIds;
    }

    public List<TrackingSitesEnum> getTrackingSites()
    {
        return trackingSites;
    }

    public void setTrackingSites(final List<TrackingSitesEnum> trackingSites)
    {
        this.trackingSites = trackingSites;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(final String middleName)
    {
        this.middleName = middleName;
    }

    public String getAdditionalHoursText()
    {
        return additionalHoursText;
    }

    public void setAdditionalHoursText(final String additionalHoursText)
    {
        this.additionalHoursText = additionalHoursText;
    }

    public String getFeaturedMessageUrl()
    {
        return featuredMessageUrl;
    }

    public void setFeaturedMessageUrl(final String featuredMessageUrl)
    {
        this.featuredMessageUrl = featuredMessageUrl;
    }

    public String getReservationUrl()
    {
        return reservationUrl;
    }

    public void setReservationUrl(final String reservationUrl)
    {
        this.reservationUrl = reservationUrl;
    }

    public List<String> getDegrees()
    {
        return degrees;
    }

    public void setDegrees(final List<String> degrees)
    {
        this.degrees = degrees;
    }

    public List<String> getLabelIds()
    {
        return labelIds;
    }

    public void setLabelIds(final List<String> labelIds)
    {
        this.labelIds = labelIds;
    }

    public String getGooglePreferredPhoto()
    {
        return googlePreferredPhoto;
    }

    public void setGooglePreferredPhoto(final String googlePreferredPhoto)
    {
        this.googlePreferredPhoto = googlePreferredPhoto;
    }

    public List<String> getVideoUrls()
    {
        return videoUrls;
    }

    public void setVideoUrls(final List<String> videoUrls)
    {
        this.videoUrls = videoUrls;
    }

    public String getFeaturedMessage()
    {
        return featuredMessage;
    }

    public void setFeaturedMessage(final String featuredMessage)
    {
        this.featuredMessage = featuredMessage;
    }

    public Double getYextDisplayLat()
    {
        return yextDisplayLat;
    }

    public void setYextDisplayLat(final Double yextDisplayLat)
    {
        this.yextDisplayLat = yextDisplayLat;
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(final String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    public ServiceArea getServiceArea()
    {
        return serviceArea;
    }

    public void setServiceArea(final ServiceArea serviceArea)
    {
        this.serviceArea = serviceArea;
    }

    public Long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(final Long timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2(final String address2)
    {
        this.address2 = address2;
    }

    public FacebookCoverPhoto getFacebookCoverPhoto()
    {
        return facebookCoverPhoto;
    }

    public void setFacebookCoverPhoto(final FacebookCoverPhoto facebookCoverPhoto)
    {
        this.facebookCoverPhoto = facebookCoverPhoto;
    }

    public Double getYextWalkableLat()
    {
        return yextWalkableLat;
    }

    public void setYextWalkableLat(final Double yextWalkableLat)
    {
        this.yextWalkableLat = yextWalkableLat;
    }

    public List<String> getBioListIds()
    {
        return bioListIds;
    }

    public void setBioListIds(final List<String> bioListIds)
    {
        this.bioListIds = bioListIds;
    }

    public String getFacebookPageUrl()
    {
        return facebookPageUrl;
    }

    public void setFacebookPageUrl(final String facebookPageUrl)
    {
        this.facebookPageUrl = facebookPageUrl;
    }

    public List<String> getEmails()
    {
        return emails;
    }

    public void setEmails(final List<String> emails)
    {
        this.emails = emails;
    }

    public Double getWalkableLng()
    {
        return walkableLng;
    }

    public void setWalkableLng(final Double walkableLng)
    {
        this.walkableLng = walkableLng;
    }

    public GenderEnum getGender()
    {
        return gender;
    }

    public void setGender(final GenderEnum gender)
    {
        this.gender = gender;
    }

    public String getWebsiteUrl()
    {
        return websiteUrl;
    }

    public void setWebsiteUrl(final String websiteUrl)
    {
        this.websiteUrl = websiteUrl;
    }

    public List<String> getSpecialties()
    {
        return specialties;
    }

    public void setSpecialties(final List<String> specialties)
    {
        this.specialties = specialties;
    }

    public String getBioListsLabel()
    {
        return bioListsLabel;
    }

    public void setBioListsLabel(final String bioListsLabel)
    {
        this.bioListsLabel = bioListsLabel;
    }

    public Double getDisplayLng()
    {
        return displayLng;
    }

    public void setDisplayLng(final Double displayLng)
    {
        this.displayLng = displayLng;
    }

    public Double getYextPickupLng()
    {
        return yextPickupLng;
    }

    public void setYextPickupLng(final Double yextPickupLng)
    {
        this.yextPickupLng = yextPickupLng;
    }

    public List<String> getProductListIds()
    {
        return productListIds;
    }

    public void setProductListIds(final List<String> productListIds)
    {
        this.productListIds = productListIds;
    }

    public GoogleCoverPhoto getGoogleCoverPhoto()
    {
        return googleCoverPhoto;
    }

    public void setGoogleCoverPhoto(final GoogleCoverPhoto googleCoverPhoto)
    {
        this.googleCoverPhoto = googleCoverPhoto;
    }

    public List<EducationList> getEducationList()
    {
        return educationList;
    }

    public void setEducationList(final List<EducationList> educationList)
    {
        this.educationList = educationList;
    }

    public Double getPickupLat()
    {
        return pickupLat;
    }

    public void setPickupLat(final Double pickupLat)
    {
        this.pickupLat = pickupLat;
    }

    public Logo getLogo()
    {
        return logo;
    }

    public void setLogo(final Logo logo)
    {
        this.logo = logo;
    }

    public String getAlternatePhone()
    {
        return alternatePhone;
    }

    public void setAlternatePhone(final String alternatePhone)
    {
        this.alternatePhone = alternatePhone;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(final String accountId)
    {
        this.accountId = accountId;
    }

    public String getMenuUrl()
    {
        return menuUrl;
    }

    public void setMenuUrl(final String menuUrl)
    {
        this.menuUrl = menuUrl;
    }

    public Boolean getAcceptingNewPatients()
    {
        return acceptingNewPatients;
    }

    public void setAcceptingNewPatients(final Boolean acceptingNewPatients)
    {
        this.acceptingNewPatients = acceptingNewPatients;
    }

    public String getDisplayWebsiteUrl()
    {
        return displayWebsiteUrl;
    }

    public void setDisplayWebsiteUrl(final String displayWebsiteUrl)
    {
        this.displayWebsiteUrl = displayWebsiteUrl;
    }

    public Double getYextRoutableLng()
    {
        return yextRoutableLng;
    }

    public void setYextRoutableLng(final Double yextRoutableLng)
    {
        this.yextRoutableLng = yextRoutableLng;
    }

    public String getState()
    {
        return state;
    }

    public void setState(final String state)
    {
        this.state = state;
    }

    public Boolean getSuppressAddress()
    {
        return suppressAddress;
    }

    public void setSuppressAddress(final Boolean suppressAddress)
    {
        this.suppressAddress = suppressAddress;
    }

    public Object getClosed()
    {
        return closed;
    }

    public void setClosed(final Object closed)
    {
        this.closed = closed;
    }

    public String getDisplayMenuUrl()
    {
        return displayMenuUrl;
    }

    public void setDisplayMenuUrl(final String displayMenuUrl)
    {
        this.displayMenuUrl = displayMenuUrl;
    }

    public String getOfficeName()
    {
        return officeName;
    }

    public void setOfficeName(final String officeName)
    {
        this.officeName = officeName;
    }

    public Double getYextDropoffLat()
    {
        return yextDropoffLat;
    }

    public void setYextDropoffLat(final Double yextDropoffLat)
    {
        this.yextDropoffLat = yextDropoffLat;
    }

    public String getHours()
    {
        return hours;
    }

    public void setHours(final String hours)
    {
        this.hours = hours;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(final String address)
    {
        this.address = address;
    }

    public String getUberLink()
    {
        return uberLink;
    }

    public void setUberLink(final String uberLink)
    {
        this.uberLink = uberLink;
    }

    public String getUberClientId()
    {
        return uberClientId;
    }

    public void setUberClientId(final String uberClientId)
    {
        this.uberClientId = uberClientId;
    }

    public FacebookProfilePicture getFacebookProfilePicture()
    {
        return facebookProfilePicture;
    }

    public void setFacebookProfilePicture(final FacebookProfilePicture facebookProfilePicture)
    {
        this.facebookProfilePicture = facebookProfilePicture;
    }

    public List<String> getCertifications()
    {
        return certifications;
    }

    public void setCertifications(final List<String> certifications)
    {
        this.certifications = certifications;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(final String language)
    {
        this.language = language;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(final String locationName)
    {
        this.locationName = locationName;
    }

    public List<QueryTemplatesEnum> getQueryTemplates()
    {
        return queryTemplates;
    }

    public void setQueryTemplates(final List<QueryTemplatesEnum> queryTemplates)
    {
        this.queryTemplates = queryTemplates;
    }

    public List<String> getProducts()
    {
        return products;
    }

    public void setProducts(final List<String> products)
    {
        this.products = products;
    }

    public String getUberLinkText()
    {
        return uberLinkText;
    }

    public void setUberLinkText(final String uberLinkText)
    {
        this.uberLinkText = uberLinkText;
    }

    public List<Object> getGoogleAttributes()
    {
        return googleAttributes;
    }

    public void setGoogleAttributes(final List<Object> googleAttributes)
    {
        this.googleAttributes = googleAttributes;
    }

    public List<String> getPaymentOptions()
    {
        return paymentOptions;
    }

    public void setPaymentOptions(final List<String> paymentOptions)
    {
        this.paymentOptions = paymentOptions;
    }

    public List<String> getCustomKeywords()
    {
        return customKeywords;
    }

    public void setCustomKeywords(final List<String> customKeywords)
    {
        this.customKeywords = customKeywords;
    }

    public Double getDropoffLng()
    {
        return dropoffLng;
    }

    public void setDropoffLng(final Double dropoffLng)
    {
        this.dropoffLng = dropoffLng;
    }

    public Boolean getIntelligentSearchTrackingEnabled()
    {
        return intelligentSearchTrackingEnabled;
    }

    public void setIntelligentSearchTrackingEnabled(final Boolean intelligentSearchTrackingEnabled)
    {
        this.intelligentSearchTrackingEnabled = intelligentSearchTrackingEnabled;
    }

    public String getUberEmbedCode()
    {
        return uberEmbedCode;
    }

    public void setUberEmbedCode(final String uberEmbedCode)
    {
        this.uberEmbedCode = uberEmbedCode;
    }

    public String getDisplayReservationUrl()
    {
        return displayReservationUrl;
    }

    public void setDisplayReservationUrl(final String displayReservationUrl)
    {
        this.displayReservationUrl = displayReservationUrl;
    }

    public Double getYextDisplayLng()
    {
        return yextDisplayLng;
    }

    public void setYextDisplayLng(final Double yextDisplayLng)
    {
        this.yextDisplayLng = yextDisplayLng;
    }

    public String getDisplayAddress()
    {
        return displayAddress;
    }

    public void setDisplayAddress(final String displayAddress)
    {
        this.displayAddress = displayAddress;
    }

    public List<String> getCategoryIds()
    {
        return categoryIds;
    }

    public void setCategoryIds(final List<String> categoryIds)
    {
        this.categoryIds = categoryIds;
    }

    public String getProductListsLabel()
    {
        return productListsLabel;
    }

    public void setProductListsLabel(final String productListsLabel)
    {
        this.productListsLabel = productListsLabel;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(final String city)
    {
        this.city = city;
    }

    public String getMenusLabel()
    {
        return menusLabel;
    }

    public void setMenusLabel(final String menusLabel)
    {
        this.menusLabel = menusLabel;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(final String zip)
    {
        this.zip = zip;
    }

    public String getLocalPhone()
    {
        return localPhone;
    }

    public void setLocalPhone(final String localPhone)
    {
        this.localPhone = localPhone;
    }

    public String getOrderUrl()
    {
        return orderUrl;
    }

    public void setOrderUrl(final String orderUrl)
    {
        this.orderUrl = orderUrl;
    }

    public Double getDropoffLat()
    {
        return dropoffLat;
    }

    public void setDropoffLat(final Double dropoffLat)
    {
        this.dropoffLat = dropoffLat;
    }

    public List<String> getConditionsTreated()
    {
        return conditionsTreated;
    }

    public void setConditionsTreated(final List<String> conditionsTreated)
    {
        this.conditionsTreated = conditionsTreated;
    }

    public Double getPickupLng()
    {
        return pickupLng;
    }

    public void setPickupLng(final Double pickupLng)
    {
        this.pickupLng = pickupLng;
    }

    public Map<String, Object> getCustomFields()
    {
        return customFields;
    }

    public void setCustomFields(final Map<String, Object> customFields)
    {
        this.customFields = customFields;
    }

    public Double getWalkableLat()
    {
        return walkableLat;
    }

    public void setWalkableLat(final Double walkableLat)
    {
        this.walkableLat = walkableLat;
    }

    public List<String> getInsuranceAccepted()
    {
        return insuranceAccepted;
    }

    public void setInsuranceAccepted(final List<String> insuranceAccepted)
    {
        this.insuranceAccepted = insuranceAccepted;
    }

    public UberLinkTypeEnum getUberLinkType()
    {
        return uberLinkType;
    }

    public void setUberLinkType(final UberLinkTypeEnum uberLinkType)
    {
        this.uberLinkType = uberLinkType;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(final String phone)
    {
        this.phone = phone;
    }

    public String getFolderId()
    {
        return folderId;
    }

    public void setFolderId(final String folderId)
    {
        this.folderId = folderId;
    }

    public GoogleProfilePhoto getGoogleProfilePhoto()
    {
        return googleProfilePhoto;
    }

    public void setGoogleProfilePhoto(final GoogleProfilePhoto googleProfilePhoto)
    {
        this.googleProfilePhoto = googleProfilePhoto;
    }

    public String getInstagramHandle()
    {
        return instagramHandle;
    }

    public void setInstagramHandle(final String instagramHandle)
    {
        this.instagramHandle = instagramHandle;
    }

    public String getEventListsLabel()
    {
        return eventListsLabel;
    }

    public void setEventListsLabel(final String eventListsLabel)
    {
        this.eventListsLabel = eventListsLabel;
    }

    public List<Object> getHolidayHours()
    {
        return holidayHours;
    }

    public void setHolidayHours(final List<Object> holidayHours)
    {
        this.holidayHours = holidayHours;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public List<String> getLanguages()
    {
        return languages;
    }

    public void setLanguages(final List<String> languages)
    {
        this.languages = languages;
    }

    public LocationType getLocationType()
    {
        return locationType;
    }

    public void setLocationType(final LocationType locationType)
    {
        this.locationType = locationType;
    }

    public List<String> getAdmittingHospitals()
    {
        return admittingHospitals;
    }

    public void setAdmittingHospitals(final List<String> admittingHospitals)
    {
        this.admittingHospitals = admittingHospitals;
    }

    public String getYearEstablished()
    {
        return yearEstablished;
    }

    public void setYearEstablished(final String yearEstablished)
    {
        this.yearEstablished = yearEstablished;
    }

    public Double getYextWalkableLng()
    {
        return yextWalkableLng;
    }

    public void setYextWalkableLng(final Double yextWalkableLng)
    {
        this.yextWalkableLng = yextWalkableLng;
    }

    public List<String> getAssociations()
    {
        return associations;
    }

    public void setAssociations(final List<String> associations)
    {
        this.associations = associations;
    }

    public Double getRoutableLng()
    {
        return routableLng;
    }

    public void setRoutableLng(final Double routableLng)
    {
        this.routableLng = routableLng;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(final String countryCode)
    {
        this.countryCode = countryCode;
    }

    public Double getYextPickupLat()
    {
        return yextPickupLat;
    }

    public void setYextPickupLat(final Double yextPickupLat)
    {
        this.yextPickupLat = yextPickupLat;
    }

    public List<LocationKeywordsEnum> getLocationKeywords()
    {
        return locationKeywords;
    }

    public void setLocationKeywords(final List<LocationKeywordsEnum> locationKeywords)
    {
        this.locationKeywords = locationKeywords;
    }

    public String getGoogleWebsiteOverride()
    {
        return googleWebsiteOverride;
    }

    public void setGoogleWebsiteOverride(final String googleWebsiteOverride)
    {
        this.googleWebsiteOverride = googleWebsiteOverride;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public List<String> getAlternateWebsites()
    {
        return alternateWebsites;
    }

    public void setAlternateWebsites(final List<String> alternateWebsites)
    {
        this.alternateWebsites = alternateWebsites;
    }

    public IntelligentSearchTrackingFrequencyEnum getIntelligentSearchTrackingFrequency()
    {
        return intelligentSearchTrackingFrequency;
    }

    public void setIntelligentSearchTrackingFrequency(final IntelligentSearchTrackingFrequencyEnum intelligentSearchTrackingFrequency)
    {
        this.intelligentSearchTrackingFrequency = intelligentSearchTrackingFrequency;
    }

    public List<String> getEventListIds()
    {
        return eventListIds;
    }

    public void setEventListIds(final List<String> eventListIds)
    {
        this.eventListIds = eventListIds;
    }

    public Double getDisplayLat()
    {
        return displayLat;
    }

    public void setDisplayLat(final Double displayLat)
    {
        this.displayLat = displayLat;
    }

    public List<Object> getCompetitors()
    {
        return competitors;
    }

    public void setCompetitors(final List<Object> competitors)
    {
        this.competitors = competitors;
    }

    public Double getYextDropoffLng()
    {
        return yextDropoffLng;
    }

    public void setYextDropoffLng(final Double yextDropoffLng)
    {
        this.yextDropoffLng = yextDropoffLng;
    }

    public Boolean getIsPhoneTracked()
    {
        return isPhoneTracked;
    }

    public void setIsPhoneTracked(final Boolean isPhoneTracked)
    {
        this.isPhoneTracked = isPhoneTracked;
    }

    public String getTtyPhone()
    {
        return ttyPhone;
    }

    public void setTtyPhone(final String ttyPhone)
    {
        this.ttyPhone = ttyPhone;
    }

    public String getNpi()
    {
        return npi;
    }

    public void setNpi(final String npi)
    {
        this.npi = npi;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getTwitterHandle()
    {
        return twitterHandle;
    }

    public void setTwitterHandle(final String twitterHandle)
    {
        this.twitterHandle = twitterHandle;
    }

    public List<String> getBrands()
    {
        return brands;
    }

    public void setBrands(final List<String> brands)
    {
        this.brands = brands;
    }

    public String getUberTripBrandingUrl()
    {
        return uberTripBrandingUrl;
    }

    public void setUberTripBrandingUrl(final String uberTripBrandingUrl)
    {
        this.uberTripBrandingUrl = uberTripBrandingUrl;
    }

    public Double getRoutableLat()
    {
        return routableLat;
    }

    public void setRoutableLat(final Double routableLat)
    {
        this.routableLat = routableLat;
    }

    public Double getYextRoutableLat()
    {
        return yextRoutableLat;
    }

    public void setYextRoutableLat(final Double yextRoutableLat)
    {
        this.yextRoutableLat = yextRoutableLat;
    }

    public List<String> getAlternateNames()
    {
        return alternateNames;
    }

    public void setAlternateNames(final List<String> alternateNames)
    {
        this.alternateNames = alternateNames;
    }

    public List<Photo> getPhotos()
    {
        return photos;
    }

    public void setPhotos(final List<Photo> photos)
    {
        this.photos = photos;
    }

    public String getDisplayOrderUrl()
    {
        return displayOrderUrl;
    }

    public void setDisplayOrderUrl(final String displayOrderUrl)
    {
        this.displayOrderUrl = displayOrderUrl;
    }

    public List<String> getServices()
    {
        return services;
    }

    public void setServices(final List<String> services)
    {
        this.services = services;
    }

    public String getSublocality()
    {
        return sublocality;
    }

    public void setSublocality(final String sublocality)
    {
        this.sublocality = sublocality;
    }

    public String getUberTripBrandingText()
    {
        return uberTripBrandingText;
    }

    public void setUberTripBrandingText(final String uberTripBrandingText)
    {
        this.uberTripBrandingText = uberTripBrandingText;
    }

    public String getUberTripBrandingDescription()
    {
        return uberTripBrandingDescription;
    }

    public void setUberTripBrandingDescription(String uberTripBrandingDescription)
    {
        this.uberTripBrandingDescription = uberTripBrandingDescription;
    }

    public Location assureMenus()
    {
        if (menuIds == null)
        {
            menuIds = new ArrayList<>();
        }

        return this;
    }

    public Location assureProducts()
    {
        if (productListIds == null)
        {
            productListIds = new ArrayList<>();
        }

        return this;
    }

}

