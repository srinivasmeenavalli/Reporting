package com.estore.search.vo;

import java.util.ArrayList;

/**
 * 
 *
 */
public class Record {
	
	private String id;
	private String sourceID;
	private String sendingCountry;
	private String responseType;
	private String EDITransmissionRefNumber;
	private String iChgCtrl;
	private String sentTS;
	private String recdTS;
	private String receiverReference;
	private String receiverReferenceDate;
	private String billOfLadingNumber;
	private String customsReference;
	private String status;
	private String errorCode;
	private String errorDescription;
	private String remarksmessage;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSourceID() {
		return sourceID;
	}
	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}
	public String getSendingCountry() {
		return sendingCountry;
	}
	public void setSendingCountry(String sendingCountry) {
		this.sendingCountry = sendingCountry;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public String getEDITransmissionRefNumber() {
		return EDITransmissionRefNumber;
	}
	public void setEDITransmissionRefNumber(String eDITransmissionRefNumber) {
		EDITransmissionRefNumber = eDITransmissionRefNumber;
	}
	public String getiChgCtrl() {
		return iChgCtrl;
	}
	public void setiChgCtrl(String iChgCtrl) {
		this.iChgCtrl = iChgCtrl;
	}
	public String getSentTS() {
		return sentTS;
	}
	public void setSentTS(String sentTS) {
		this.sentTS = sentTS;
	}
	public String getRecdTS() {
		return recdTS;
	}
	public void setRecdTS(String recdTS) {
		this.recdTS = recdTS;
	}
	public String getReceiverReference() {
		return receiverReference;
	}
	public void setReceiverReference(String receiverReference) {
		this.receiverReference = receiverReference;
	}
	public String getReceiverReferenceDate() {
		return receiverReferenceDate;
	}
	public void setReceiverReferenceDate(String receiverReferenceDate) {
		this.receiverReferenceDate = receiverReferenceDate;
	}
	public String getBillOfLadingNumber() {
		return billOfLadingNumber;
	}
	public void setBillOfLadingNumber(String billOfLadingNumber) {
		this.billOfLadingNumber = billOfLadingNumber;
	}
	public String getCustomsReference() {
		return customsReference;
	}
	public void setCustomsReference(String customsReference) {
		this.customsReference = customsReference;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getRemarksmessage() {
		return remarksmessage;
	}
	public void setRemarksmessage(String remarksmessage) {
		this.remarksmessage = remarksmessage;
	}



}
