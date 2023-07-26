package com.mtb;

public class MtbSpecsBean {
	
	//Bike, size, STL, TTL, R, S, CSL, HTL, HTL, HTA, STA(E), BBH, WB, SOH, BBO
	//assumes all measurements are in mm
	private String bikeName;
	private String bikeSize;
	private Integer seatTubeLength;
	private Integer topTubeLength;
	private Integer reach;
	private Integer stack;
	private Integer chainstayLength;
	private Integer headTubeLength;
	private Double headTubeAngle;
	private Double seatTubeAngleEffective;
	private Integer bottomBracketHeight;
	private Integer wheelBase;
	private Integer standOverHeight;
	private Integer bottomBracketOffset;
	
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getBikeSize() {
		return bikeSize;
	}
	public void setBikeSize(String bikeSize) {
		this.bikeSize = bikeSize;
	}
	public Integer getSeatTubeLength() {
		return seatTubeLength;
	}
	public void setSeatTubeLength(Integer seatTubeLength) {
		this.seatTubeLength = seatTubeLength;
	}
	public Integer getTopTubeLength() {
		return topTubeLength;
	}
	public void setTopTubeLength(Integer topTubeLength) {
		this.topTubeLength = topTubeLength;
	}
	public Integer getReach() {
		return reach;
	}
	public void setReach(Integer reach) {
		this.reach = reach;
	}
	public Integer getStack() {
		return stack;
	}
	public void setStack(Integer stack) {
		this.stack = stack;
	}
	public Integer getChainstayLength() {
		return chainstayLength;
	}
	public void setChainstayLength(Integer chainstayLength) {
		this.chainstayLength = chainstayLength;
	}
	public Integer getHeadTubeLength() {
		return headTubeLength;
	}
	public void setHeadTubeLength(Integer headTubeLength) {
		this.headTubeLength = headTubeLength;
	}
	public Double getHeadTubeAngle() {
		return headTubeAngle;
	}
	public void setHeadTubeAngle(Double headTubeAngle) {
		this.headTubeAngle = headTubeAngle;
	}
	public Double getSeatTubeAngleEffective() {
		return seatTubeAngleEffective;
	}
	public void setSeatTubeAngleEffective(Double seatTubeAngleEffective) {
		this.seatTubeAngleEffective = seatTubeAngleEffective;
	}
	public Integer getBottomBracketHeight() {
		return bottomBracketHeight;
	}
	public void setBottomBracketHeight(Integer bottomBracketHeight) {
		this.bottomBracketHeight = bottomBracketHeight;
	}
	public Integer getWheelBase() {
		return wheelBase;
	}
	public void setWheelBase(Integer wheelBase) {
		this.wheelBase = wheelBase;
	}
	public Integer getStandOverHeight() {
		return standOverHeight;
	}
	public void setStandOverHeight(Integer standOverHeight) {
		this.standOverHeight = standOverHeight;
	}
	public Integer getBottomBracketOffset() {
		return bottomBracketOffset;
	}
	public void setBottomBracketOffset(Integer bottomBracketOffset) {
		this.bottomBracketOffset = bottomBracketOffset;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MtbSpecsBean [bikeName=").append(bikeName).append(", bikeSize=").append(bikeSize)
				.append(", seatTubeLength=").append(seatTubeLength).append(", topTubeLength=").append(topTubeLength)
				.append(", reach=").append(reach).append(", stack=").append(stack).append(", chainstayLength=")
				.append(chainstayLength).append(", headTubeLength=").append(headTubeLength).append(", headTubeAngle=")
				.append(headTubeAngle).append(", seatTubeAngleEffective=").append(seatTubeAngleEffective)
				.append(", bottomBracketHeight=").append(bottomBracketHeight).append(", wheelBase=").append(wheelBase)
				.append(", standOverHeight=").append(standOverHeight).append(", bottomBracketOffset=")
				.append(bottomBracketOffset).append("]");
		return builder.toString();
	}

}
