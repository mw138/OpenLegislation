package gov.nysenate.openleg.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Member extends Person implements Serializable
{
    private static final long serialVersionUID = -8348372884270872363L;

    /** Unique member id generated by the persistence layer. */
    private int memberId;

    /** Current mapping to LBDC's representation of the member id.
     *  This shortName is only unique to the scope of a (2 year) session */
    private String lbdcShortName;

    /** The session year the member is active in. */
    private int sessionYear;

    /** The legislative chamber this member is associated with. */
    private Chamber chamber;

    /** Indicates if the member is currently an incumbent. */
    private boolean incumbent;

    /** The district number the member is serving in during the given session year. */
    private Integer districtCode;

    /** --- Constructors --- */

    public Member() {}

    public Member(Member other) {
        super(other);
        this.memberId = other.memberId;
        this.lbdcShortName = other.lbdcShortName;
        this.sessionYear = other.sessionYear;
        this.chamber = other.chamber;
        this.incumbent = other.incumbent;
        this.districtCode = other.districtCode;
    }

    /** --- Overrides --- */

    /**
     * Ignores LBDC Shortname since there can be multiple variations.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        final Member other = (Member) obj;
        return Objects.equals(this.memberId, other.memberId) &&
               Objects.equals(this.sessionYear, other.sessionYear) &&
               Objects.equals(this.chamber, other.chamber) &&
               Objects.equals(this.incumbent, other.incumbent) &&
               Objects.equals(this.districtCode, other.districtCode);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hash(memberId, sessionYear, chamber, incumbent, districtCode);
    }

    @Override
    public String toString() {
        return lbdcShortName + " (year: " + sessionYear + ", id: " + memberId + ")";
    }

    /** --- Basic Getters/Setters --- */

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Chamber getChamber() {
        return chamber;
    }

    public void setChamber(Chamber chamber) {
        this.chamber = chamber;
    }

    public boolean isIncumbent() {
        return incumbent;
    }

    public void setIncumbent(boolean incumbent) {
        this.incumbent = incumbent;
    }

    public String getLbdcShortName() {
        return lbdcShortName;
    }

    public void setLbdcShortName(String lbdcShortName) {
        this.lbdcShortName = lbdcShortName;
    }

    public int getSessionYear() {
        return sessionYear;
    }

    public void setSessionYear(int sessionYear) {
        this.sessionYear = sessionYear;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }
}