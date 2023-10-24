package edu.umb.cs680.hw2;

import java.util.Iterator;
import java.util.LinkedList;

public class SingletonPrimeGenerator {
    private static SingletonPrimeGenerator Obj;
    protected  long from,to;
    protected LinkedList<Long> primes = new LinkedList<Long>();
// creating an private constructor , it will prevent to instantiate the singlrton class from anyother outside class
    private SingletonPrimeGenerator(){}

    // creating a static Factory method provides Global point of access to the Singleton object
    // and returns the instance to the caller.
    public  static SingletonPrimeGenerator getInstance(){
        if(Obj == null){
            Obj = new SingletonPrimeGenerator();
        }
        return Obj;
    }
//Creating a method that returns From and To values
    public void SetValues(long from, long to){
        if(from>=1 && to >from){
            this.from =from;
            this.to =to;
        }else{
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }
    public LinkedList<Long> getPrimes()
    {
        return primes;
    };

    protected boolean isEven(long n){
        if(n%2 ==0){
            return true;
        }
        else {
            return false;
        }
    }

    protected boolean isPrime(long n){
        // 1 or lower numbers are not prime.
        if(n <= 1){ return false; }
        // Even numbers are not prime, except for 2.
        if( n > 2 && isEven(n) ){ return false; }
        long i;
        // Find a number "i" that can divide "n"
        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
        // If such a number "i" is found, n is not prime. Otherwise, n is prime.
        if (i == 1){ return true; }
        else{ return false; }
    }

    public void generatePrimes(){
        for (long n = from; n <= to; n++) {
            if( isPrime(n) ){ primes.add(n); }
        }
    }

    public static void main(String[] args) {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance();
        gen.SetValues(2,25);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        Iterator<Long> it = primes.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println("\n" + gen.getPrimes().size() + " primes are found.");
    }



}
