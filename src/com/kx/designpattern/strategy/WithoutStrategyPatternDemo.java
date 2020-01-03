package com.kx.designpattern.strategy;

/**
 * @author kx
 * @date 2020/1/3 10:57
 */
public class WithoutStrategyPatternDemo {



	public static void main(String[] args) {
		int discount = 1;

		if (discount == 1) {
			System.out.println("策略1");
		} else if (discount == 2) {
			System.out.println("策略2");
		} else if(discount == 3) {
			System.out.println("策略3");
		} else {
			System.out.println("策略4");
		}
	}

}
