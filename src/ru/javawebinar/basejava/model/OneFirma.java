package ru.javawebinar.basejava.model;

import java.util.Objects;

public class OneFirma {

    private final String jobName;
    private final String jobLink;
    private final String startDate;
    private final String endDate;
    private final String position;
    private final String positionInfo;

    public OneFirma(String jobName, String jobLink, String startDate, String endDate, String position, String positionInfo) {
        this.jobName = jobName;
        this.jobLink = jobLink;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.positionInfo = positionInfo;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobLink() {
        return jobLink;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPosition() {
        return position;
    }

    public String getPositionInfo() {
        return positionInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneFirma)) return false;
        OneFirma oneFirma = (OneFirma) o;
        return Objects.equals(getJobName(), oneFirma.getJobName()) &&
                Objects.equals(getJobLink(), oneFirma.getJobLink()) &&
                Objects.equals(getStartDate(), oneFirma.getStartDate()) &&
                Objects.equals(getEndDate(), oneFirma.getEndDate()) &&
                Objects.equals(getPosition(), oneFirma.getPosition()) &&
                Objects.equals(getPositionInfo(), oneFirma.getPositionInfo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getJobName(), getJobLink(), getStartDate(), getEndDate(), getPosition(), getPositionInfo());
    }

    @Override
    public String toString() {
        return "OneFirma{" +
                "jobName='" + jobName + '\'' +
                ", jobLink='" + jobLink + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", position='" + position + '\'' +
                ", positionInfo='" + positionInfo + '\'' +
                '}';
    }

}
