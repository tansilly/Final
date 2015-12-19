package domain;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class RateDomainModel implements Serializable {
	
	private UUID RateID;
	private int MinCreditScore;
	private double InterestRate;
	
	public RateDomainModel()
	{
		
	}
	
	public RateDomainModel(int minCreditScore, double interestRate) {
		super();
		this.setRateID(UUID.randomUUID());		
		MinCreditScore = minCreditScore;
		InterestRate = interestRate;
	}

	public RateDomainModel(RateDomainModel rate)
	{
		super();
		this.setRateID(UUID.randomUUID());		
		MinCreditScore = rate.getMinCreditScore();
		InterestRate = rate.getInterestRate();
		
	}
	
	public UUID getRateID() {
		return RateID;
	}
	private void setRateID(UUID rateID) {
		RateID = rateID;
	}
	public int getMinCreditScore() {
		return MinCreditScore;
	}
	public void setMinCreditScore(int minCreditScore) {
		MinCreditScore = minCreditScore;
	}
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	
	
}