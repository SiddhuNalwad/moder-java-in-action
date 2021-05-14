package com.modernjavainaction.chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TraderTransactionExercise {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		
		//1. Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> answer = null;
		answer = transactions.stream()
				.filter(t -> t.getYear()==2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.toList();
		System.out.println("answer1:" + answer);
		
		//2. What are all the unique cities where the traders work?
		List<String> cities = 
				transactions.stream()
				.map(t -> t.getTrader().getCity())
				.distinct()
				.toList();
		
		//2nd solution
		Set<String> cities2 = transactions.stream()
		.map(t -> t.getTrader().getCity())
		.collect(Collectors.toSet());
		
		System.out.println("answer2#1:" + cities);
		System.out.println("answer2#2:" + cities2);
		
		//3. Find all traders from Cambridge and sort them by name.
		List<Trader> traderCambridgeNames = 
				transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct() //removes any duplicates
				.sorted(Comparator.comparing(Trader::getName))
				.toList();
		System.out.println("answer3:" + traderCambridgeNames);
		
		//4. Return a string of all traders’ names sorted alphabetically.
		String traderNames = 
		transactions.stream()
			.map(Transaction::getTrader)
			.sorted(Comparator.comparing(Trader::getName))
			.map(Trader::getName)
			.distinct()
			.reduce("", (s1, s2) -> s1 + s2);
		System.out.println("answer4#1:" + traderNames);
		traderNames = 
				transactions.stream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (s1,s2)-> s1 + s2);
		System.out.println("answer4#2:" + traderNames);
		
		//5. Are any traders based in Milan?
		boolean anyTradreInMilan = 
				transactions.stream()
				.anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println("answer5:" + anyTradreInMilan);
		
		//6. Print the values of all transactions from the traders living in Cambridge.
		List<Integer> values = 
				transactions.stream()
				.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
				.map(t -> t.getValue())
				.toList();
		System.out.println("answer6:" + values);
		
		//7. What’s the highest value of all the transactions?
		Optional<Transaction> highestValueTransaction =  
				transactions.stream()
				.max(Comparator.comparing(Transaction::getValue));
		highestValueTransaction.ifPresentOrElse(t -> System.out.println("answer7:" + t.getValue()), () -> System.out.print("No max transaction"));
		
		//8. Find the transaction with the smallest value.
		Optional<Transaction> lowestValueTransaction = 
				transactions.stream()
				.min(Comparator.comparing(Transaction::getValue));
		lowestValueTransaction.ifPresentOrElse(t -> System.out.println("answer8:" + t), () -> System.out.print("No max transaction"));

	}
}
