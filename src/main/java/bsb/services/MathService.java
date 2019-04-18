package bsb.services;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class MathService {

	public MathService() { }
	public static final String[] precedence = { "(", "^", "*", "/", "+", "-" };
	
	public BigDecimal calc(String expression) {
		if (expression.matches("\\d+\\^\\d+"))
			return powerOf(expression.split("\\^"));
		else if (expression.matches("\\d+\\*\\d+"))
			return multiply(expression.split("\\*"));
		else if (expression.matches("\\d+\\/\\d+"))
			return divide(expression.split("\\/"));
		else if (expression.matches("\\d+\\+\\d+"))
			return add(expression.split("\\+"));
		else if (expression.matches("\\d+-\\d+"))
			return subtract(expression.split("-"));
		else {
			return new BigDecimal(0);
		}
	}
	public BigDecimal powerOf(String... nums) {
		if (nums == null || nums.length == 0)
			return new BigDecimal(1);
		else if (nums.length == 1)
			return new BigDecimal(nums[0]);
		else {
			BigDecimal bd1 = new BigDecimal(nums[0]);
			BigDecimal bd2 = new BigDecimal(nums[1]);
			return bd1.pow(bd2.intValue()).pow(powerOf(Arrays.copyOfRange(nums, 2, nums.length)).intValue());
		}
	}
	public BigDecimal multiply(String... nums) {
		if (nums == null || nums.length == 0)
			return new BigDecimal(1);
		else if (nums.length == 1)
			return new BigDecimal(nums[0]);
		else {
			BigDecimal bd1 = new BigDecimal(nums[0]);
			BigDecimal bd2 = new BigDecimal(nums[1]);
			return bd1.multiply(bd2).multiply(multiply(Arrays.copyOfRange(nums, 2, nums.length)));
		}
	}

	public BigDecimal divide(String... nums) {
		if (nums == null || nums.length == 0)
			return new BigDecimal(1);
		else if (nums.length == 1)
			return new BigDecimal(nums[0]);
		else {
			BigDecimal bd1 = new BigDecimal(nums[0]);
			BigDecimal bd2 = new BigDecimal(nums[1]);
			return bd1.divide(bd2).divide(divide(Arrays.copyOfRange(nums, 2, nums.length)));
		}
	}
	public BigDecimal add(String... nums) {
		if (nums == null || nums.length == 0)
			return new BigDecimal(0);
		else if (nums.length == 1)
			return new BigDecimal(nums[0]);
		else {
			BigDecimal bd1 = new BigDecimal(nums[0]);
			BigDecimal bd2 = new BigDecimal(nums[1]);
			return bd1.add(bd2).add(add(Arrays.copyOfRange(nums, 2, nums.length)));
		}
	}
	public BigDecimal subtract(String... nums) {
		if (nums == null || nums.length == 0)
			return new BigDecimal(0);
		else if (nums.length == 1)
			return new BigDecimal(nums[0]);
		else {
			BigDecimal bd1 = new BigDecimal(nums[0]);
			BigDecimal bd2 = new BigDecimal(nums[1]);
			return bd1.subtract(bd2).subtract(subtract(Arrays.copyOfRange(nums, 2, nums.length)));
		}
	}
	
	
}
